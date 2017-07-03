package Threads

class ThreadLe {

	static main(args){
		def thread = Thread.start{
			def start=System.nanoTime()
			new Object().sleep(1000)
			def end=System.nanoTime()
			println "duration is ${(end-start)}"
		}
		
		thread.interrupt()
		thread.join()
		
		/*
		 * difference between object.sleep and Thread.sleep????
		 */
		
	}
}
