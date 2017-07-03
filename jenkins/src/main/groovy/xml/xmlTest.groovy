package xml

import gojo.VM

/**
 * Created by wanjia on 3/24/2017.
 */
class xmlTest extends GroovyTestCase{
    void test(){
        // create xml
        def xmlstr = new myXmlBuilder().buildXml(new VM(name:"machine1",ip: "1.2.3.4",product:"uft"));

        // parse xml
        def xml = new XmlParser().parseText(xmlstr)
        def vmproduct= xml.vm.collect{
            it.@product +":"+ it.name.text()

        }
        println vmproduct.getClass()
        vmproduct.each{
            println it
        }
    }
}
