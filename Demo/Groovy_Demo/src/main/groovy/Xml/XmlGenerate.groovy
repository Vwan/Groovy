package Xml

import groovy.xml.StreamingMarkupBuilder

class XmlGenerate {
	static langs = ['C++' : 'Stroustrup' , 'Java' : 'Gosling' , 'Lisp' : 'McCarthy' ]
	/*
	 * GString + Multiline£º embed expressions into a string along
	 * with Groovy¡¯s facility for creating multiline strings.
	 */

	public static MultiLineGString(){
		
		def str =""
		langs.each{lang,author->
			str = str + """
				<language name="$lang">
					<author>$author</author>
			"""
		}
		return "<languages>$str</languages>"
	}
	
	/*
	 * MarkupBuilder
	 */
	public static XmlMarkupBuilder(){
		def xml = new StreamingMarkupBuilder().bind{
			mkp.xmlDeclaration()
			mkp.declareNamespace(test:'Natural')
			languages {
				comment << "this is created via builder"
				langs.each{lang,value->
					test.language(name:lang){
						author(value)
					}
					
				}
				//language (name:groovy,author:vivian)
			}
		}
		return xml
	}
	
	
	/*
	 * StreamingMarkupBuilder
	 */
	static main(args){
		//println MultiLineGString()
		println XmlMarkupBuilder()
	}
}
