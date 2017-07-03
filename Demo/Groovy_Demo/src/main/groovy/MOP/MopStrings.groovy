package MOP

class MopStrings {
	static newMethod2(str,newMethod){
		newMethod(str)
	}
	static def newMethod1 = {
		println it
	}
	static main (args){
		String.metaClass {
			def str="test"//123//"test"
		//	println str.metaClass.respondsTo(str,"toUpperCase")?"yes":"no"
		//	println str.metaClass.getMetaMethod("toUpperCase")?.invoke(str)
			
			str.properties.each{
		//		println it
			}
		
			String.metaClass.testNewMethod{
		//		println "this is a new method"
			}
			
		/*	def newMethod1 = {
				println it
			}*/
			
			this.newMethod2("method 2",this.newMethod1)
			
			def newMethod3 = {key,value=3->
				println "$key+$value"
			}
			
			newMethod3(1,2)
			newMethod3(1)
			
			5.times{
				println it
			}
			
			//"test".each (newMethod1)
			//"test".testNewMethod()
			
			Integer.metaClass.daysFromNow = { ->
				Calendar today = Calendar.instance
				today.add(Calendar.DAY_OF_MONTH, delegate)
				today.time
				}
			
			println 5.daysFromNow()
		}
	}
}
