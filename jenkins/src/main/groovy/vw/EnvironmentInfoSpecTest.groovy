package vw

//@Grab('org.spockframework:spock-core:*')
import spock.lang.Specification

/**
 * Created by wanjia on 4/5/2017.
 */

class EnvironmentInfoSpecTest extends Specification {
    def "test GetOSType for Windows"(){
        println "OS is: $EnvironmentInfo.OSType"
        expect:
            EnvironmentInfo.OSType == "Windows"
    }

    void "test GetLocale for Windows"(){
        println "Locale is: $EnvironmentInfo.locale"
        println "Locale Name is: $EnvironmentInfo.localeName"
        expect:
            EnvironmentInfo.localeName == "en_US"
            EnvironmentInfo.locale == new Locale("en","US")
    }

    void "test GetJaveHome for Windows"(){
        def envInfoMap = EnvironmentInfo.envInfo
        println envInfoMap["JAVA_HOME"]
        expect:
            envInfoMap["JAVA_HOME"]== "C:\\Program Files (x86)\\Java\\jdk1.8.0_121"
    }

}
