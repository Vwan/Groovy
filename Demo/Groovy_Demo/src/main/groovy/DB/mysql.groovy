package DB
import groovy.sql.Sql
import groovy.xml.MarkupBuilder

class mysql {
	static main (args){
	def sql = Sql.newInstance('jdbc:mysql://localhost:3306/REST','root','','com.mysql.jdbc.Driver')
//	println sql.connection.catalog
	def rowlist = sql.eachRow('select * from projects'){
		//println (it.id + it.description+it.name)
		it.id
		it.name
	}
	//println sql.rows('select * from projects')
	
	def xml = new MarkupBuilder()
	xml.project{
		sql.eachRow('select * from projects') {
			name{mkp.yield '4>5'}		
		id(id:it.id,'3<7')
	}
	}
}
}
