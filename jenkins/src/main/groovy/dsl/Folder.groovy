package dsl

/**
 * Created by wanjia on 3/8/2017.
 */
class Folder {
    String name

    static create(closure){
        Folder folder = new Folder()
        closure.delegate=folder
        closure()
        folder.doCreate(folder)
    }

    def doCreate(Folder folder){
        new File(folder.name).mkdirs()
    }
    def name (String name){
        this.name=name;
    }

}
