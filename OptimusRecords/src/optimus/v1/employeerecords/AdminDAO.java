package optimus.v1.employeerecords;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
/*
 * public class AdminDAO
 * Used for performing various data access on Admin POJO & admin table
 */
public class AdminDAO {

	private Configuration config;
	private SessionFactory factory;
	private Session newSession;
	private Transaction newTransaction;
	private JSONObject admin;
	/*
	 * method: public int checkAdmin(String loginCredentials)
	 * Takes loginCredentials as String in JSON format
	 * Used for checking whether the following login credentials are of a valid admin
	 */
	public int checkAdmin(String loginCredentials){
		
		admin = new JSONObject(loginCredentials);
		int check=-1;
		try{
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			Query getQuery = newSession.createQuery("FROM Admin WHERE userName=:userName AND password=:password ");
			getQuery.setParameter("userName", admin.getString("userName"));
			getQuery.setParameter("password", admin.getString("password"));
			List <Admin> list;
			list = getQuery.list();
			Iterator <Admin> iterator = list.iterator();
			if(iterator.hasNext()){
				 check=1;
				
			}
			newTransaction.commit();
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			newSession.close();
			
		}
		return check;
	
	}
	
}
