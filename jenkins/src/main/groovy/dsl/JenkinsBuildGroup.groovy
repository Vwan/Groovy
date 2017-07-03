package dsl

/**
 * Created by wanjia on 3/8/2017.
 */
class JenkinsBuildGroup {
    def name
    def xml
    def repoList

    /**
     * Use methodMissing to load the xml and repos closures
     * @param methodName
     * @param args
     */
    def methodMissing(String methodName, args) {

        if (methodName.equals("xml")) {
            xml = new Expando()
            Closure closure = args[0]
            closure.setDelegate(xml)
            closure.setResolveStrategy(Closure.DELEGATE_ONLY)
            closure()
        } else if (methodName.equals("repos")) {
            repoList = new Expando()
            Closure closure = args[0]
            closure.setDelegate(repoList)
            closure.setResolveStrategy(Closure.DELEGATE_ONLY)
            closure()
        } else {
            log.error "Unsupported option: " + methodName
        }
    }

    def updateJenkins(def jenkinsHttp) {
        xml.getProperties().each { String jobType, String filePath ->

            def configXml = new File(filePath).text

            repoList.getProperties().each { String jobName, String repo ->
                String jobXml = configXml.replaceAll("REPOSITORY_URL", repo)
                jenkinsHttp.createOrUpdate(jobName + "-" + jobType, jobXml)
            }
        }
    }
}
