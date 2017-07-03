package ex

/**
 * Created by wanjia on 3/22/2017.
 */
class ExampleHandlerTest extends GroovyTestCase{
    def f1(){println "f1 script is called"}
    static void main(args) {
        new Example().foo {
            f1 ()
            f2 ()
        }
    }
}
