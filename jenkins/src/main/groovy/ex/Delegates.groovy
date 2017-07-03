package ex

/**
 * Created by wanjia on 3/22/2017.
 */
class Delegates {
    static def examiningClosure(closure) {
        closure()
    }
    static void main(args) {
        examiningClosure() {
            println "In First Closure:"
            println "class is " + getClass().name
            println "this is " + this + ", super:" + this.getClass().superclass.name
            println "owner is " + owner + ", super:" + owner.getClass().superclass.name
            println "delegate is " + delegate +
                    ", super:" + delegate.getClass().superclass.name
            examiningClosure() {
                println "In Closure within the First Closure:"
                println "class is " + getClass().name
                println "this is " + this + ", super:" + this.getClass().superclass.name
                println "owner is " + owner + ", super:" + owner.getClass().superclass.name
                println "delegate is " + delegate +
                        ", super:" + delegate.getClass().superclass.name
            }
        }
    }
}