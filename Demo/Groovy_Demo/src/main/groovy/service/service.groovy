package service
import groovy.json.JsonSlurper

class service {
	static main (args){
		def type="json"//"xml"
		def url ="https://maps.googleapis.com/maps/api/timezone/"+type+"?"
		def URI="http://www.thomas-bayer.com/sqlrest"
		def parameters = ["location":"-33.86,151.20","timestamp":"12","language":"zh_CN"]
		//location=&timestamp=12&language=zh_CN
		url=url+parameters.collect(){key,value->
			"$key=$value"
		}.join("&")
		println url
		
		def jsonFilename="D:\\APP\\Sprinter\\Hydro\\UserActionsData.json"
		
		def xml = new XmlSlurper().parse(URI)
		//println xml.CUSTOMERList.@'xlink:href'
		
		def json = new JsonSlurper().parseText(new File(jsonFilename).text)
		println json.'controlsList'.'default'{
			it.name=="Focus#0"
		}
	}
}
