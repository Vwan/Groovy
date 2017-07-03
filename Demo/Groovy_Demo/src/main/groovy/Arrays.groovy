
class Arrays {

	static main(args) {
		String[] arrStr = ['Ananas', 'Banana', 'Kiwi']
		
		assert arrStr instanceof String[]
		assert !(arrStr instanceof List)
		
		def numArr = [1, 2, 3] as int[]
		
		assert numArr instanceof int[]
		assert numArr.size() == 3
		
		int[] numArr1 = [1,2,3]
		assert numArr1.size()==3
	

	// multi dimensional
	def matrix3 = new Integer[3][3]
	assert matrix3.size() == 3
	
	Integer[][] matrix2
	matrix2 = [[1, 2], [3, 4]]
	assert matrix2 instanceof Integer[][]

	String[] names = ['C¨¦dric', 'Guillaume', 'Jochen', 'Paul']
	assert names[0] == 'C¨¦dric'
	
	names[2] = 'Blackdrag'
	assert names[2] == 'Blackdrag'
	}
	}
