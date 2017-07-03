/*
 * Groovy Collections
 */
class Collections {

	static main(args) {
	
		// Define a collection
		def c1 = [1,2,3,4]
		def c2= new ArrayList()
		
		// Add new items to collection
		c1.add(5)
		c2<<1
		c2[1]=2
		c2[c2.size()]=3
		c2 = c2 + 4
		assert c1 == [1,2,3,4,5]
		assert c2 ==[1,2,3,4]
		
		// delete items from a collection
		c1.remove(0)
		c2=c2-2
		assert c1==[2,3,4,5]
		assert c2==[1,3,4]
		
		// Add new collection to collection
		c1.add(c2)
		assert c1==[2,3,4,5,[1,3,4]]
		
		// delete a collection from a collection
		c2 = c2 - c2[0..<1]
		assert c2==[3,4]
		
		// search items
		println c1[0]; // by index
		println c1[-1] // print the last item
		println c1[0..4]
		
		// Loop a collection
		c1.each{
			println it
		}
		
		for (i in 0..c2.size()-1){
			println "the #$i item in c2 is: "+c2[i]
		}
		
		(0..c2.size()-1).each{
			println c2[it]
		}

}
}
