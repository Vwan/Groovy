package Test

import dsl.Validator
import gojo.Customer

/**
 * Created by wanjia on 3/8/2017.
 */
class ValidatorTest extends GroovyTestCase{
    void test(){
        def customer = new Customer(age:18,name:"test")
        print customer.age
        print customer.name
        def c = new Validator()
                c.validate(customer)
    }
}
