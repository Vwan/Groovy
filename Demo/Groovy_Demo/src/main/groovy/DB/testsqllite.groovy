package DB
import groovy.sql.*
/**
 * Created by wanjia on 2017/5/30.
 */
def dbFile = "jdbc:sqlite:c:\\Libraries\\Documents\\sqlitedb.db"///pathToTestdb/testdb.db"
def getDb(dbFile){
    return Sql.newInstance(dbFile, "org.sqlite.JDBC")
}
void insert(sql1,id,name){
    sql1.execute("insert into test(colname1, colname2) values(?, ?)", [id, name])
}
void update(id){

}
void printContents(){
    sql.rows("select * from myTable order by date desc").each{
        println(it)
    }
}


sqlw = getDb(dbFile)
//insert(sqlw,2,"test 2")


