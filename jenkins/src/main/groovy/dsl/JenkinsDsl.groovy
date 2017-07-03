package dsl

import groovyx.net.http.HTTPBuilder

/**
 * Created by wanjia on 3/8/2017.
 */
// https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
/*@Grapes(
        @Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.3')
)
*/
class JenkinsDsl {
    def call(Closure cl){
        print "start processing"
        cl.setDelegate(this)
        cl.setResolveStrategy(Closure.DELEGATE_ONLY)
        cl.call()
    }

    def url
    def apiKey
    def username

    def jenkinsHttp
    def MethodMissing(String methodName,args) {
        if (methodName.equals("buildGroup")) {
            Closure closure = args[0]
            closure.delegate = new JenkinsBuildGroup()
            closure.setResolveStrategy(Closure.DELEGATE_ONLY)
            closure()
            closure.delegate.updateJenkins(getJenkinsHttp())
        } else {
            print "upspported method:" + methodName
        }
    }
        def getJenkinsHttp(){
            if(!jenkinsHttp){
                jenkinsHttp=new HTTPBuilder(url,username,apiKey)
            }
            jenkinsHttp
        }
    }

