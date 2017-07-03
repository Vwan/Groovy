package dsl

/**
 * Created by wanjia on 3/8/2017.
 */
class Validator {
    def subject
    public void validate(def o){
        subject=o
        o.constraints.setDelegate(this)
        o.constraints.call()
        println "validation done"
    }

    Object invokeMethod(String name, Object args) {
        def val = subject.getProperty(name)
        args[0].each {
            switch(val?.class) {
                case null: if (it.key =="blank" && !val)
                    println "failed: property '${name}' is null."
                    break
                case Integer :
                    if (it.key == "size" && !(it.value.contains(val)))
                        println "failed: Integer property '${name}' has value '${val}' not in range '${it.value.inspect()}'."
                    break
                case String: if (it.key =="size" && !it.value?.contains(val.length()))
                    println "failed: String property '${name}' has value '${val}' not in length range '${it.value.inspect()}'."
                    break
                default:
                    break
            }
        }
    }
}
