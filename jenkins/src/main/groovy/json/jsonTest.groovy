package json

/**
 * Created by wanjia on 3/23/2017.
 */
class jsonTest extends GroovyTestCase{
    void test(){
        def text = new File("src/main/resources/test.json").getText()
       /* myJsonOutput jsb = new myJsonOutput()
        def json = '''{name:test,password: ac}'''
        jsb.productJson(json);
        */
        new myJsonBuilder().produceJson()
        def json = groovy.json.JsonOutput.toJson(text)
        new myJsonParser().parseJson(text,'firstName','test')
    //    new myJsonBuilder().produceJson("test1","ac1")
    //    new myJsonParser().parseJson(text,'firstName','test')
    }


}
