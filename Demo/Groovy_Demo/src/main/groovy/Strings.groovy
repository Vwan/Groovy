
class Strings {

	static main(args) {
	
		/*
		 * GString and Plain String has different hashcode
		 */
		assert "one: ${1}".hashCode() == "one: 1".hashCode()
		
		/*
		 * When we try to fetch the value with a String key, we will not find it, as Strings and GString have different hashCode values
		 */
		
		def key = "a"
		def m = ["${key}": "letter ${key}"]
		
		assert m["a"] == null
	}

}
