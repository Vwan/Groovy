package File

class TextFile {

	static main(args){
		def dir="c:\\temp\\test"
		def fname="test.txt"
		def file = new File(dir,fname)
		// check if dir exists, creat if not
		new File(dir).mkdirs();
		// check if file exists
		//create a new file if not exists
		if (!file.exists()){
			file.write("my groovy file\n")
		}
		/*
		 *  write file
		 */
		file << '''A single line\n'''
		file.withWriter('UTF-8') {writer->
			writer.writeLine("�й�")
			writer.writeLine("Hello")
		}
		// write bytes
		//file.bytes=[55, 44, 55]
		// deal with output stream
		file.withOutputStream {stream ->
			// no need to close stream using ��withOutputStream" (not the case for file.newOutputStream")
			//	stream.

			/*
			 * Read Files
			 */
			file.eachLine{ println it }
			file.eachLine{line,linenumber->
				println "$linenumber: $line"
			}
			file.withReader{reader ->
				while (reader.readLine()){
					println reader.readLine();
				}
			}
			println file.text
			// collect lines to list
			def list=	file.collect{it};
			list.each{ println "list: "+it }
			// collect lines as array
			def array=file as String[]
			array.each{ println "array:" +it }
			// get file conents as byte
			def bytes = file.bytes;
			println "bytes: $bytes";
			// read from inputstream
			file.withInputStream {stream1 ->
			}
		}
	}

}
