package Xml
import groovy.xml.*
import groovy.xml.dom.*

class XmlParse {
	/*
	 * XmlSlurper: accessing xml directly using element names, attributes
	 * performs lazy evaluation thus good memory usage
	 */
	public static xmlSlurperParser(str){
		def xml = new XmlSlurper().parseText(str)
		def languageNames = xml.language.@name as List
		println "XmlSlurper parsing - language names: $languageNames"
		def authors = xml.'language'.'author'.collect()
		println "XmlSlurper parsing - authors: $languageNames"
	}
	
	/*
	 * XmlParser: accessing xml directly using element names, attributes
	 * doesn't preserve the xml infoSet
	 * ignore xml comments and processing instructions
	 * memory consumption high for large document
	 */
	public static xmlParser(str){
		def xml = new XmlParser().parseText(str)
		def languageNames = xml.language.@name as List
		println "XmlParser parsing - language names: $languageNames"
		def authors = xml.'language'.'author'.collect()
		println "XmlParser parsing - authors: $languageNames"
	}
	
	/*
	 * parsing xml using DOM API + GPath
	 */
	public DOMCatetoryParser(FileReader fd){
		def document = DOMBuilder.parse(fd)
		def root = document.documentElement
		use (DOMCategory){
			def languageNames = root.language
			println "DOMCatetory parsing......."
			languageNames.each{
				println "language name is ${it.'@name'} authored by ${it.author.text()}"
			}
			println languageNames.'@name'.collect().join("------")
	}
	}
	
	/*
	 * parsing xml with namespaces
	 */
	public static xmlSlurperParserNS(str,ns){
		def xml = new XmlSlurper().parseText(str).declareNamespace('test': ns)
		println xml.language.@name as List
		println xml.'test:language'.@name as List
	}
	
	
	
 static main(args){
	 def filename="./src/demo.xml"
	 def file = new File(filename)
	 def str = file.getText()
	/// this.xmlSlurperParser(str)
	// xmlParser(str)
	// (new XmlParsing()).DOMCatetoryParser(new FileReader(filename))
	 def strNS = new File("./src/demoNS.xml").getText()
	 xmlSlurperParserNS(strNS,'Natural')
 }
}
