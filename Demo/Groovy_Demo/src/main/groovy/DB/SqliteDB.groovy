package DB

/**
 * Created by wanjia on 2017/5/30.
 */

        def dbFile = "jdbc:sqlite:c:\\Libraries\\Documents\\sqlitedb.db"///pathToTestdb/testdb.db"
        def getDb(dbFile){
            return groovy.sql.Sql.newInstance(dbFile, "org.sqlite.JDBC")
        }
        void insert(sql,id,name){
            sql.execute("insert into test(colname1, colname2) values(?, ?)", [id, name])
        }
        void update(id){

        }
        void printContents(){
            sql.rows("select * from myTable order by date desc").each{
                println(it)
            }
        }

            def sqll = new SqliteDB()
            def db = sqll.getDb(dbFile)
            sqll.insert(2,"test 2")


