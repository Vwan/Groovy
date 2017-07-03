package Collections

class Lists {
	static main (args){
		/*
		 * using with,identity to create contexts
		 */
		def list = [];
		list.with {
			add(1)
			add(2)
			println size()
			println contains(2)
		}
		
		list.identity {
			add(3)
			println it
		}
		
		/* 
		 * delegate
		 */
		list.identity{
			println "this is ${this}"
			println "owner is ${owner}"
			println "delegate is ${delegate}"
		}
	}
}
