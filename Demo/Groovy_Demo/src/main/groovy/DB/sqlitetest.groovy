package DB


/**
 * Created by wanjia on 2017/5/30.



@Grapes([
        @Grab(group='org.xerial', module='sqlite-jdbc', version='3.7.2'),
        @GrabConfig(systemClassLoader=true)
])
import java.util.regex.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

// load the sqlite-JDBC driver using the current class loader
Class.forName("org.sqlite.SQLite")

groovy.sql.Sql connection = null

try {
    // create a database connection
    connection = groovy.sql.Sql.newInstance("jdbc:sqlite:c:\\Libraries\\Documents\\sqlitedb.db","org.sqlite.JDBC")

    //connection.execute("create table person (id integer, name string)")
    connection.execute("insert into test values(1, 'test1')")
    connection.eachRow("select * from test") {
        println("name = " + it.getString("name"))
        println("id = " + it.getInt("id"))
    }
}
catch(SQLException e) {
    System.err.println("sql: " + e.getMessage())
}
finally {
    try {
        if(connection != null)
            connection.close();
    }
    catch(SQLException e) {
        // connection close failed.
        System.err.println("sql: " + e)
    }
}
 */