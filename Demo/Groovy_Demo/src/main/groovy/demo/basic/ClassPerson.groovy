/*
 * Groovy Class
 * No public descriptor
 * No type definition
 * No getter/setter methods
 * No constructors
 * No return
 * No () for method calls
 */
class ClassPerson {

	def firstname;
	def lastname;
	
	String toString(){
		 "$firstname,$lastname"   // no return
	}

	static main(args){
		ClassPerson cp = new ClassPerson()	
		cp.firstname="who"
		cp.lastname="ami"
		println cp
		
		def person = new ClassPerson("firstname":"who1","lastname":'ami1') // groovy style
		println person
	}
}
