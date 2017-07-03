package vw

/**
 * Created by wanjia on 4/5/2017.
 */
class EnvironmentInfoTest extends GroovyTestCase {
    void testGetOSType_Windows(){
        println "OS is: $EnvironmentInfo.OSType"
        assert EnvironmentInfo.OSType == "Windows"
    }

    void testGetLocale(){
        println "Locale is: $EnvironmentInfo.locale"
        println "Locale Name is: $EnvironmentInfo.localeName"
    }

    void testGetJavaHome(){
        def envInfoMap = EnvironmentInfo.envInfo
        envInfoMap.each {key,value->
            println "$key ----- $value"
        }
        println envInfoMap["JAVA_HOME"]
        assert envInfoMap["JAVA_HOME"]
    }

}
