package vw

/**
 * Created by wanjia on 4/5/2017.
 */
class EnvironmentInfo {
    static def OSType
    static def localeName
    static Locale locale
    static Map envInfo
    static Map sysProperties

    static def getLocale(){
        locale= Locale.getDefault()
        localeName=locale.toString()//locale.toLanguageTag()
        return locale
    }

    static def getOSType() {
        def property = System.getProperty('os.name')
        switch (true) {
            case (property =~ /.*Windows.*/).matches():
                return "Windows"
                break;
            case (property =~ /.*(Linux).*/).matches():
                return "Linux"
                break;
            default:
                return null
        }
    }

    static def getEnvInfo(){
        System.getenv()
    }


}
