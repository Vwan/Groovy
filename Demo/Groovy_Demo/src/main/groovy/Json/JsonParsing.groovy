package Json

import groovy.transform.PackageScope

class JsonParsing {
	PackageScope ps;
	void jsparse(map){
		def json = new groovy.json.JsonBuilder()
		json(map)
		println json.toString()
	}
	static main(args){
		
		def map = [name:"Test : ( %2f %25 \$ * & ! @ # ^)"]
		def json = new groovy.json.JsonBuilder()
		json(map)
		//println json.toString()
		
		def incoming = '{"name":"Test : ( %2f %25 $ * & ! @ # ^)"}'
		def jsonInput = new groovy.json.JsonSlurper()
		def map1 = jsonInput.parseText(incoming)
	//	println map1
		
		jsparse(map)
		
	}
}
