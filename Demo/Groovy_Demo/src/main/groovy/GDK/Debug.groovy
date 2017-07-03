package GDK

class Debug {
	def s;
	static main(args){
		/*
		 * dump,inspect
		 */
		
		def str="test"
		println str.dump()
		println str.inspect()
		def list = [1,2,3]
		println list.dump()
		println list.inspect()
		
		def map = [name:"Test :( %2f %25 \$ * & ! @ # ^)"]
		String s = map.inspect()
		println s
		println Eval.me(s)
		println Debug.getClass().inspect()
	}
}
