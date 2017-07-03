package json

import groovy.json.JsonSlurper

/**
 * Created by wanjia on 3/23/2017.
 */
class myJsonParser {
    def parseJson(json,src, target) {
        def jsonSlurper = new JsonSlurper()
        def j = jsonSlurper.parseText(json)
       // assert j."$src" == target
        j.vms[0].address[0].find{key,value->
            println value
        }
        def l = j.vms[0].address[0].collect{key,value->
            println value
            key=="city"
            value
        } as String[] //as List
        println l

        l*.each{
            println it
        }
    }
}
