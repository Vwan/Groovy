package GDK

class Extensions {
	static main(args){
		/*
		 * array Range
		 */
		def list =[1,2,3]
		println list[1..2]
		println list[1..<2]
		
		/*
		 * Number
		 */
		1.upto(10) {
			println it
		}
		10.downto(1) {
			println it
		}
	}
}
