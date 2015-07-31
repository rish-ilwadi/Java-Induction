package optimus.v1.employeerecords;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

public class AdminDAO {

	private Configuration config;
	private SessionFactory factory;
	private Session newSession;
	private Transaction newTransaction;
	private JSONObject admin;
	public int checkAdmin(String loginCredentials){
		
		admin = new JSONObject(loginCredentials);
		int check=0;
		try{
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			newSession = factory.openSession();
			newTransaction = newSession.beginTransaction();
			Query getQuery = newSession.createQuery("FROM Admin WHERE userName=:userName AND password=:password ");
			getQuery.setParameter("name", admin.getString("userName"));
			getQuery.setParameter("email", admin.getString("password"));
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
			return check;
		}
	
	}
	
}
