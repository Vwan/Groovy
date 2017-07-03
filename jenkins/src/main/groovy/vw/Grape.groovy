package vw

/**
 * Created by wanjia on 2017/4/7.
 */
@Grapes(
        // @Grab(group='org.spockframework', module='spock-core', version='1.1-groovy-2.4-rc-4')
        @Grab('org.spockframework:spock-core:1.1-groovy-2.4-rc-4')
)
@Grab('org.spockframework:spock-core:*')
@Grab('commons-io:commons-io:2+')
import java.lang.Object

def add(a,b){
    return a + b
}
def "test"(){
    given:
    expect:
        println add(2,3)
        add(2,3)==6
}

"test"()