package classLe

class Cat {
		def name
		def meow(){println "meow"}
		def meow(str) {println "meow "+str}

	static main(args){
	def cat = new Cat(name:'mimi')
	println cat.name
	println cat['name']
	println cat.@name
	
	def methods= cat.getMetaClass().getMethods()
	
		cat.invokeMethod("meow",null)
		cat.invokeMethod("meow", "i'm hungry")
		
	
	}
	}
