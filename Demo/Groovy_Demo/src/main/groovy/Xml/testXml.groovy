import groovy.xml.MarkupBuilder
import groovy.xml.XmlUtil

/**
 * Created by wanjia on 2015/12/12.
 */
class testXml {
    static main (args){
        println "test"
        def xml = new MarkupBuilder()
        xml.test{
            id(id:1,"value1")
        }

        xml= xml.toString()
    def xml1 = new XmlSlurper().parseText(xml)
        xml.appendNode{
            name(name:2,"name1")
        }

        println xml
    }
}