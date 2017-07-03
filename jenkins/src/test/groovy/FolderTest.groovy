package groovy.dsl

import dsl.Folder

/**
 * Created by wanjia on 3/8/2017.
 */
class FolderTest extends GroovyTestCase{
void test(){
    def dirname="c:\\testdsl"
    Folder.create(){
        name dirname
    }
    print new File(dirname).exists()
}
}
