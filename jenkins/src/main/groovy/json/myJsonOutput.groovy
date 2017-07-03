package json
/**
 * Created by wanjia on 3/23/2017.
 */
class myJsonOutput {
    def productJson(json){
        new File("src/main/resources/test.json").write(groovy.json.JsonOutput.toJson(json))
    }
}
