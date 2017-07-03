package Collections

class InternalIterate {
	static main(args){
		def list = [1,2,3]
		def s = list.each({
		//	println it*2
			it*2
			})
		println "s is $s"
		list.each{
			//println it
			}
		s = list.collect{it*2}
		println "s is $s"
		
		list.every{
		//	println it>2
		}
		list.reverseEach{println  it}
		list.eachWithIndex {i,value->println i+":"+value}
		
		println list.inject(2) {carryOver,value->carryOver+value}
		
		def list2 =["test method","test methods","private thing"]
		println list2.groupBy{
			it.split(' ')[0]
		}
	}
}
