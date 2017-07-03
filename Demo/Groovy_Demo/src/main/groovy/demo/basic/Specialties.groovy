/*
 * Some groovy style specific features
 */
class Specialties {

	int sum(int... var) {
		def total = 0
		for (i in var)			total += i
		return total
		}
	
	static main(args) {
	
		/*
		 * ? operator to avoid nullpointer exception
		 */
		def nullable;
		def str = nullable?:"this is null value"
		println str
			

	/*
	 * variable length
	 */
	
	println sum(1)
	println sum(1,2,3)
}
}
