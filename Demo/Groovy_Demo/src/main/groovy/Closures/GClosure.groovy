package Closures

class GClosure {
	static void test(i,c){
		c(i)
	}
	
	static main(args){
		test(10.29,{println "its int value is:"+it.intValue()})
		test("stri") {println "its length is ${it.size()}"			
		}
	}
}
