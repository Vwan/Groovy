package Strings

class strings {
	static main(args){
		def s1='a'
		def s2='a' as char
		println s1.class
		println s2.class
		println '$s1'
		def s3="a"
		println s3.class
		println "s3 is $s3"
		println '/test$s3/'
		
		def s4="this is a test method"
		println s4-"test"
		println s4.tokenize().join('*')  // to check
		
		def str = 'Groovy is groovy, really groovy'
		println str
		def result = (str =~ /groovy/).replaceAll('hip' )
		println result
	}
}
