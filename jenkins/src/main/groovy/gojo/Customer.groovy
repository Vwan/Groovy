package gojo

/**
 * Created by wanjia on 3/8/2017.
 */
class Customer {
    int age
    String name
    static constraints={
        if (age <17 || age > 60) print "false" else print "true"
        if (name.length()<5 || name.length()==0) return false
    }
}
