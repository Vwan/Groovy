package dsl

import hudson.model.ParametersAction
import javaposse.jobdsl.dsl.Job
import hudson.model.*
/**
 * Created by wanjia on 2017/4/17.
 */
class DefineJobs {
    static def nodes = ["Node_CHS"]

    // define a dispatcher job
    def defineJob(nodes, jobName) {
        return job(jobName) {
            nodes.each {
                parameters {
                    activeChoiceParam(it) {
                        description('Allows user choose from choices')
                        filterable()
                        choiceType('SINGLE_SELECT')
                        scriptlerScript('getAllNodesByProject.groovy') {
                            parameter('project', 'ALM')
                        }
                    }
                    fileParam('test/upload.zip', 'my description')
                }
            }
        }
    }

    def seedJob() {
        job(jobName) {
            parameters {
                nodeParam(nodeName) {
                    description('Select Test Node')
                    defaultNodes([node.value.toString()])
                    allowedNodes([node.value.toString()])
                }
            }
            steps {
                batchFile('echo Hello World!')
            }

        }
    }

    def test(){
        /*def nodes = jenkins.model.Jenkins.instance.slaves.findAll{
  if (it.name.contains(project)) it.name
}.collect{it.name}
nodes.add(0,"None")
*/
        def nodes = ["Client_JPN","Client_CHS"]

        defineJob(nodes,"dispatcher")
        // define a dispatcher job
        def defineJob(nodes,jobName) {
            return job(jobName) {
                nodes.each {
                    def node =it
                    parameters {
                        activeChoiceParam(node) {
                            description('Allows user choose from choices')
                            filterable()
                            choiceType('SINGLE_SELECT')
                            scriptlerScript('getAllNodesByProject.groovy') {
                                parameter('project', 'Client')
                            }
                        }
                        fileParam(node+'_File', 'Select test case file to upload')
                    }
                }

                def build = Thread.currentThread()?.executable
                // get the selected node parameter value at runtime
                def node = build?.actions.find { it instanceof ParametersAction }

                def test = 1?.parameters

                import hudson.model.*
                def nodes = hudson.model.Hudson.instance.slaves.findAll{
                    if (it.name.contains("Client")) it.name
                }.collect{it.name}
                nodes.add(0,"None")

//def nodes = ["Client_JPN","Client_CHS"]

                defineJob(nodes-["None"],"dispatcher")

                // define a dispatcher job
                def defineJob(nodes,jobName) {
                    return job(jobName) {
                        def list =[]
                        nodes.each {
                            def node =it
                            parameters {
                                activeChoiceParam(node) {
                                    description('Allows user choose from choices')
                                    filterable()
                                    choiceType('SINGLE_SELECT')
                                    scriptlerScript('getAllNodesByProject.groovy') {
                                        parameter('project', 'Client')
                                    }
                                }
                                fileParam(node+'_File', 'Select test case file to upload')
                            }
                        }

                        steps {
                            //systemGroovyScriptFile('C:\\Users\\wanjia\\.jenkins\\scriptler\\scripts\\getRuntimeNodes.groovy') {
                            systemGroovyCommand(readFileFromWorkspace("${JENKINS_HOME}\\scriptler\\scripts\\getRuntimeNodes.groovy")){
                            }
                            conditionalSteps {
                                condition {
                                    booleanCondition("\${runable}")
                                }

                                steps{ downstreamParameterized {
                                    trigger('seed') {
                                        /* parameters{
                                          println node
                                         nodeLabelBuildParameter {
                                            name(node)
                                            nodeLabel(node)
                                          }*/
                                        parameterFactories {
                                            nodeListBuildParameterFactory {

                                                // The name of the parameter to set.
                                                name("test")
                                                // A comma separated list of nodes to execute the job on.
                                                nodeListString("\${runtimeNodes}")

                                            }
                                            //booleanParam("f",true) /
                                        }
                                    }
                                }
                                }
                            }
                        }
                    }
                }



}