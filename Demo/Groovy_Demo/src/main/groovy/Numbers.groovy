
class Numbers {
	public PlainNumbers(){
		// primitive types
		byte  b = 1
		char  c = 2
		short s = 3
		int   i = 4
		long  l = 5

		// infinite precision
		BigInteger bi =  6

		/*
		 *
		 */

		def a = 1
		assert a instanceof Integer

		// Integer.MAX_VALUE
		def b1 = 2147483647
		assert b1 instanceof Integer

		// Integer.MAX_VALUE + 1
		def c1 = 2147483648
		assert c1 instanceof Long

		// Long.MAX_VALUE
		def d = 9223372036854775807
		assert d instanceof Long

		// Long.MAX_VALUE + 1
		def e = 9223372036854775808
		assert e instanceof BigInteger

		//	As well as for negative numbers:

		def na = -1
		assert na instanceof Integer

		// Integer.MIN_VALUE
		def nb = -2147483648
		assert nb instanceof Integer

		// Integer.MIN_VALUE - 1
		def nc = -2147483649
		assert nc instanceof Long

		// Long.MIN_VALUE
		def nd = -9223372036854775808
		assert nd instanceof Long

		// Long.MIN_VALUE - 1
		def ne = -9223372036854775809
		assert ne instanceof BigInteger
	}

	public BinaryLiterals(){
		int xInt = 0b10101111
		assert xInt == 175
		short xShort = 0b11001001
		assert xShort == 201 as short

		byte xByte = 0b11
		assert xByte == 3 as byte

		long xLong = 0b101101101101
		assert xLong == 2925l

		BigInteger xBigInteger = 0b111100100001
		assert xBigInteger == 3873g

		int xNegativeInt = -0b10101111
		assert xNegativeInt == -175
	}

	/*
	 Octal literal
	 Octal numbers are specified in the typical format of 0 followed by octal digits.
	 */
	public OctalLiteral(){
		int xInt = 077
		assert xInt == 63

		short xShort = 011
		assert xShort == 9 as short

		byte xByte = 032
		assert xByte == 26 as byte

		long xLong = 0246
		assert xLong == 166l

		BigInteger xBigInteger = 01111
		assert xBigInteger == 585g

		int xNegativeInt = -077
		assert xNegativeInt == -63
	}
	/*
	 Hexadecimal literal
	 Hexadecimal numbers are specified in the typical format of 0x followed by hex digits.
	 */
	public Hexadecimalliteral(){
		int xInt = 0x77
		assert xInt == 119

		short xShort = 0xaa
		assert xShort == 170 as short

		byte xByte = 0x3a
		assert xByte == 58 as byte

		long xLong = 0xffff
		assert xLong == 65535l

		BigInteger xBigInteger = 0xaaaa
		assert xBigInteger == 43690g

		Double xDouble = new Double('0x1.0p0')
		assert xDouble == 1.0d

		int xNegativeInt = -0x77
		assert xNegativeInt == -119
	}
	/*
	 Decimal literals
	 The decimal literal types are the same as in Java:
	 float
	 double
	 java.lang.BigDecimal
	 You can create decimal numbers of those types with the following declarations:
	 */
	public DecimalLiterals(){
		// primitive types
		float  f = 1.234
		double d = 2.345

		// infinite precision
		BigDecimal bd =  3.456

		//Decimals can use exponents, with the e or E exponent letter, followed by an optional sign, and a integral number representing the exponent:

		assert 1e3  ==  1_000.0
		assert 2E4  == 20_000.0
		assert 3e+1 ==     30.0
		assert 4E-2 ==      0.04
		assert 5e-1 ==      0.5

		/*Conveniently for exact decimal number calculations, Groovy choses java.lang.BigDecimal as its decimal number type. In addition, both float and double are supported, but require an explicit type declaration, type coercion or suffix. Even if BigDecimal is the default for decimal numbers, such literals are accepted in methods or closures taking float or double as parameter types.
		 Decimal numbers can¡¯t be represented using a binary, octal or hexadecimal representation.*/

	}

	/*Underscore in literals
	 When writing long literal numbers, it¡¯s harder on the eye to figure out how some numbers are grouped together, for example with groups of thousands, of words, etc. By allowing you to place underscore in number literals, it¡¯s easier to spot those groups:
	 */
	public UnderscoreInLiterals(){
		long creditCardNumber = 1234_5678_9012_3456L
		long socialSecurityNumbers = 999_99_9999L
		double monetaryAmount = 12_345_132.12
		long hexBytes = 0xFF_EC_DE_5E
		long hexWords = 0xFFEC_DE5E
		long maxLong = 0x7fff_ffff_ffff_ffffL
		long alsoMaxLong = 9_223_372_036_854_775_807L
		long bytes = 0b11010010_01101001_10010100_10010010
	}

	/*
	 Number type suffixes
	 We can force a number (including binary, octals and hexadecimals) to have a specific type by giving a suffix (see table bellow), either uppercase or lowercase.
	 Type 	Suffix
	 BigInteger
	 G or g
	 Long
	 L or l
	 Integer
	 I or i
	 BigDecimal
	 G or g
	 Double
	 D or d
	 Float
	 F or f
	 Examples:
	 */
	public NumberTypeSuffix(){
		assert 42I == new Integer('42')
		assert 42i == new Integer('42') // lowercase i more readable
		assert 123L == new Long("123") // uppercase L more readable
		assert 2147483648 == new Long('2147483648') // Long type used, value too large for an Integer
		assert 456G == new BigInteger('456')
		assert 456g == new BigInteger('456')
		assert 123.45 == new BigDecimal('123.45') // default BigDecimal type used
		assert 1.200065D == new Double('1.200065')
		assert 1.234F == new Float('1.234')
		assert 1.23E23D == new Double('1.23E23')
		assert 0b1111L.class == Long // binary
		assert 0xFFi.class == Integer // hexadecimal
		assert 034G.class == BigInteger // octal
	}

	static main(args) {
		def numbers = new Numbers()
		//this.NumberTypeSuffix()
		numbers.NumberTypeSuffix()
		numbers.OctalLiteral()
		numbers.BinaryLiterals()
		numbers.Hexadecimalliteral()
		numbers.UnderscoreInLiterals()
		numbers.PlainNumbers()
	}


}

