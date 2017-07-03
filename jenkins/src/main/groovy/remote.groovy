package groovy
/**
 * Created by wanjia on 2017/2/27.
 */
class remote {
  static void main(args){
    def JENKINS_URL="http://16.60.158.120:8080"
    def JOB_NAME="test"
      def json='''
{
"parameter":[
               { "name":"NodeName", "value":"UFT_AUTO_JPN"}
]
}
'''
    def proc = """
curl -X POST $JENKINS_URL/job/$JOB_NAME/build
""".execute()
      def procWithParameter= """
curl -X POST $JENKINS_URL/job/$JOB_NAME/build --data-urlencode json=$json
""".execute()
    Thread.start{
        System.err << proc.err
        println proc.text
    }
    proc.waitFor()
}
}
