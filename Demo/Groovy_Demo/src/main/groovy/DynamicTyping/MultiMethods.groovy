package DynamicTyping

class MultiMethods {
			
		static int method(String arg) {
			return 1;
		}
		static int method(Object arg) {
			return 2;
		}
		
		static main(args){
			Object o = "Object";
			println o.class
			println o.class.superclass
			int result = method(o);
			assert result==2
		}
}
