package Json
import groovy.json.JsonSlurper
import groovy.json.StreamingJsonBuilder
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

/**
 * Created by wanjia on 2015/12/12.
 */
class jsoncreate{
	//static @Delegate JsonParsing jp = new JsonParsing()
static main(args){
def sw = new StringWriter()
def str= new StreamingJsonBuilder(sw)

        str.products {

            ["user1", "user2"].eachWithIndex {v,index->
                user {
                id(index)
                name(v)
            }
        }
    }
		def map = [name:"Test : ( %2f %25 \$ * & ! @ # ^)"]
		new jsoncreate().jsparse1(map)
		println sw.class

}
}