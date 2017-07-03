package File

class txt {
	static main(args){
		def str='''
line test 1
line 2
		line 3'''
		def file = new File("c:\\temp\\test.txt")//.write(str)
		file.eachLine{
			//println it
		}
		//println file?.text
		
		file.withWriter{
			file << "line  test 4"
		}
		file.withReader {
		//	println it.text
		}
		println file.filterLine{
			it=~ /test/
		}
	}
}
