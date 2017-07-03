/*
 * Groovy Map: LinkedHashMap
 */
class Map {

	static main(args) {
		
		//define map
		def map=['id':1,'first name':'vivian','last name':'wan']
		
		// Add map items
			   map=map+['gender':'female']     		
			   map.put('height',1.5)  		
			   map.project='sv'   
		
		// Search Map items
			   println map['project']  
			   println map.height     
	}

}
