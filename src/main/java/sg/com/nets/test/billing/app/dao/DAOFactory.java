package sg.com.nets.test.billing.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sg.com.nets.test.billing.app.model.StringConstant;

/***
 * 
 * DAO Factory
 * Note: only accepts mysql and neo4j
 * Please check application.properties and make sure
 * config.database-type is set to mysql or neo4j 
 * 
 *@author Miranda Aristotle
 **/

@Component("daoFactory")
public class DAOFactory {

	
	@Autowired
	@Qualifier("mysqlJPA")
	private BillingDAO  mysqlDAO;
	
	@Autowired
	@Qualifier("noSQLRepo")
	private BillingDAO neo4jDAO;
		
	@Value("${config.database-type}")
   	private String databaseType;

	public BillingDAO  getDAO() {
		
		BillingDAO dao = null;
		
		switch (databaseType) {
		case StringConstant.DB_MYSQL:
			dao = mysqlDAO;
			break;
		case StringConstant.DB_NEO4J:
			dao = neo4jDAO;
			break;
		default:
			System.out.println(StringConstant.UNKNOWN_DATABASE);
			break;
		}
		
		return dao;
	}
	
	
}
