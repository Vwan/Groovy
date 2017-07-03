package GDK

class Processes {
	static main(args){
		Process proc = Runtime.getRuntime().exec("svn help")
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()))
		def line;
		
		while ((line = br.readLine())!=null){
		//	println line;
		}
		
		//println "svn help".execute().text
		Process p = "wc".execute()
		/*
		 * withWriter( ). This method attaches an OutputStreamWriter to
the OutputStream and hands it to the closure. When you return from
the closure, it flushes and closes the stream automatically.
		 */
		p.out.withWriter{
			it << "line 1\n"
			it << "line 2"
		}
		println p.in.text
		
/*
 * passing parameters
 */
		String[] command = ['groovy' , '-e' , 'println "Groovy!"' ]
		println "Calling ${command.join(' ')}"
		println command.execute().text
	}
}
