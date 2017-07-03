package xml

/**
 * Created by wanjia on 3/24/2017.
 */
class myXmlParser {
    def parseXml(xml){
        def xmlParser = new XmlParser()
        def root = xmlParser.parseText(xml)
        root.each{
            println it
        }
    }
}
