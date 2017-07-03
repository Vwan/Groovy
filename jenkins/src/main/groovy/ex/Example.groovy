package ex

/**
 * Created by wanjia on 3/22/2017.
 */
class Example {
    def f1(){
        println "f1 example is called"
    }
    def f2(){
        println "f2 example is called"
    }
    def foo(closure){
        closure.delegate = new Handler()
        closure()
    }


}
