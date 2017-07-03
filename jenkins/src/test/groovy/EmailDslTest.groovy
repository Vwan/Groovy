package Test

import dsl.EmailDsl

/**
 * Created by wanjia on 2017/2/28.
 */
class EmailDslTest extends GroovyTestCase{
    void test(){
        EmailDsl.send(){
            to 'vivian.wan'
            from 'test'
            body 'hello'
            xml
        }
    }
}
