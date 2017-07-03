/*
 *  	by being explicit when declaring a variable holding the character by specifying the char type
	by using type coercion with the as operator
	by using a cast to char operation
	The first option 1 is interesting when the character is held in a variable, while the other two (2 and 3) are more interesting when a char value must be passed as argument of a method call. 
 */
class Characters {

	static main(args){
	char c1 = 'A'
	assert c1 instanceof Character
	
	def c2 = 'B' as char
	assert c2 instanceof Character
	
	def c3 = (char)'C'
	assert c3 instanceof Character
}
}