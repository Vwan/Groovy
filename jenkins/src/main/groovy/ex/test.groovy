package ex

/**
 * Created by wanjia on 3/24/2017.
 */
def x = 1
println "----"+x.hashCode()
def gs = "x = ${x}"
assert gs == 'x = 1'

x=2
println "-----"+x.hashCode()
println gs.hashCode()
gs = "x=${-> x}"
assert gs == 'x=2'

println System.properties['os.name']