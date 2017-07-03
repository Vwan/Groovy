package dsl

import hudson.model.*
/**
 * Created by wanjia on 2017/4/15.
 */
class triggerJobs {

    static def langs = ["CHS", "JPN"]

    static def jobName = 'ALM_GUI_REG_Seed_New'

    static void main() {
        langs.each {
            def node = "Node_" + it
            // trigger seed job on specified nodeName
            runJob(node, jobName)
        }
    }

        // define a method to trigger job
       static def runJob(nodeName, jobName) {
            def build = Thread.currentThread()?.executable
            // get the selected node parameter value at runtime
            def node = build?.actions.find { it instanceof ParametersAction }?.parameters.find {
                it.name == nodeName
            }
            println "Node is $node"
            if (node != 'None') {
                // trigger seed job
                println "Triggering seed job..."

                // define a seed job with runtime node passed.
                def seedJob = job(jobName) {
                    parameters {
                        nodeParam(nodeName) {
                            description('Select Test Node')
                            defaultNodes([node.toString()])
                            allowedNodes([node.toString()])
                        }
                    }
                    steps {
                        batchFile('echo Hello World!')
                    }
                }
                // run see job
                println "running REG seed job on Node: " + nodeName
                queue(seedJob)
            }
        }
    }
}
