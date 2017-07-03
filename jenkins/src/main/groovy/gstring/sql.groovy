package gstring

/**
 * Created by wanjia on 2017/4/9.
 */
class sql extends GroovyTestCase {
    void test(){
        def gs = "${x,y-> x+y}"
        println gs
    }
}
