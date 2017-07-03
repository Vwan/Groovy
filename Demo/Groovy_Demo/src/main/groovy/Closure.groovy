/*
 * Closures in groovy
 */

class Closure {

	static main(args) {
	
		/*
		 *  Iterate Collections/Map
		 */
		def list = [1,2,3,4]
		def map=['id':1,'first name':'vivian','last name':'wan']
		
		list.each{
			println it
		}
		
		map.each{key,value->
			println "key is $key" + " and value is $value"
		}
		
		/*
		 * define closures separately
		 */
		def sayHello={name->
			println "hello "+name
		}
		sayHello("team 1")
		sayHello.call("team 2")
	

	/*
	 * closure as object and pass to methods
	 */
	map.each({key,value->
		println "key is $key" + " and value is $value"
	})
}
}
