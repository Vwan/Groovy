package xml

import gojo.VM
import groovy.xml.MarkupBuilder

/**
 * Created by wanjia on 3/24/2017.
 */
class myXmlBuilder {

    def writer = new StringWriter()
    def builder = new MarkupBuilder(writer)

    def buildXml(VM machine){
        builder.vms {
            vm(product:machine.product) {
                name (machine.name)
                ip (machine.ip)
            }
        }
          println writer.toString()
        return writer.toString()
    }


}
