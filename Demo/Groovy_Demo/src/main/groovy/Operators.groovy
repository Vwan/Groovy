
class Operators {

	public NormalOperators(){
		assert  1  + 2 == 3
		assert  4  - 3 == 1
		assert  3  * 5 == 15
		assert  3  / 2 == 1.5
		assert 10  % 3 == 1
		assert  2 ** 3 == 8
	}
	
	public UnaryOperators(){
		/*Unary operators
		
		The + and - operators are also available as unary operators:
		*/
		assert +3 == 3
		assert -4 == 0 - 4
		
		assert -(-1) == 1
		/*
			Note the usage of parentheses to surround an expression to apply the unary minus to that surrounded expression.
		
		In terms of unary arithmetics operators, the ++ (increment) and -- (decrement) operators are available, both in prefix and postfix notation:
		*/
		def a = 2
		def b = a++ * 3
		
		assert a == 3 && b == 6
		
		def c = 3
		def d = c-- * 2
		
		assert c == 2 && d == 6
		
		def e = 1
		def f = ++e + 3
		
		assert e == 2 && f == 5
		
		def g = 4
		def h = --g + 1
		
		assert g == 3 && h == 4
		
		/*	The postfix increment will increment a after the expression has been evaluated and assigned into b
			The postfix decrement will decrement c after the expression has been evaluated and assigned into d
			The prefix increment will increment e before the expression is evaluated and assigned into f
			The prefix decrement will decrement g before the expression is evaluated and assigned into h*/
	}
	
	public ArithmaticOperation(){
		def a = 4
		a += 3
		
		assert a == 7
		
		def b = 5
		b -= 3
		
		assert b == 2
		
		def c = 5
		c *= 3
		
		assert c == 15
		
		def d = 10
		d /= 2
		
		assert d == 5
		
		def e = 10
		e %= 3
		
		assert e == 1
	}
	
	public RelationalOperator(){
		assert 1 + 2 == 3
		assert 3 != 4
		
		assert -2 < 3
		assert 2 <= 2
		assert 3 <= 4
		
		assert 5 > 1
		assert 5 >= -2
	}
	
	public LogicalOperator(){
		assert !false
		assert true && true
		assert true || false
	}
	
	public BitwiseOperator(){
		int a = 0b00101010
		assert a==42
		int b = 0b00001000
		assert b==8
		assert (a & a) == a
		assert (a & b) == b
		assert (a | a) == a
		assert (a | b) == a
		
		int mask = 0b11111111
		assert ((a ^ a) & mask) == 0b00000000
		assert ((a ^ b) & mask) == 0b00100010
		assert ((~a) & mask)    == 0b11010101
	}
	
	public ConditionalOperator(){
		//not
		assert (!true)    == false
		assert (!'foo')   == false
		assert (!'')      == true
		//Ternary 
		result = (string!=null && string.length()>0) ? 'Found' : 'Not found'
		if (string!=null && string.length()>0) {
			result = 'Found'
		} else {
			result = 'Not found'
		}
		result = string ? 'Found' : 'Not found'
		displayName = user.name ? user.name : 'Anonymous' // tenary
		displayName = user.name ?: 'Anonymous' //Elvis
		
		//
		
	}
	
	public ObjectOperator(){
		def person = Person.find { it.id == 123 }
		def name = person?.name
		assert name == null
	}
	
	static main(args) {
	
	}

}
