package optimus.addressbook;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * public class AuthenticationDAO
 * DAO class for Authentication table
 */
public class AuthenticationDAO {
	/*
	 * Data Members 
	 *
	 */
	private Configuration config;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private Logger log;
	public AuthenticationDAO(){
		log = Logger.getLogger(AuthenticationDAO.class);
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
	}
	/*
	 * public String checkGuestLogin(String email, String password)
	 * Takes email & password
	 * & check whether the user is a guest user or not
	 */
	public String checkGuestLogin(String email, String password){
		
		String check = null;
		log.debug("Entering checkGuestLogin()");
		try{
			log.info("connecting to the database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			log.info("Verifying in the database");
			Query query = session.createQuery("FROM Authentication WHERE role=:role AND email =:email AND password =:password");
			query.setParameter("role", "Guest");
			query.setParameter("email", email );
			query.setParameter("password", password);
			List <Authentication> list;
			list = query.list();
			Iterator iterator = list.iterator();
			
			if(iterator.hasNext()){
				check = "Valid User";
				log.info("User valid");
			}
			else{
				log.info("User In valid ");
				check = "Invalid User";
			}
			transaction.commit();
			
		}catch(HibernateException exception){
			
			log.error("authentication operation failed. Exception occured. "+exception.getMessage());
		}finally{
			session.close();
		}
		return check;
	}
	/*
	 * public String checkAdminLogin(String email, String password)
	 * Takes email & password
	 * & check whether the user is a admin user or not
	 */
	public String checkAdminLogin(String email, String password){
		
		String check = null;
		log.debug("Entering checkGuestLogin()");
		try{
			log.info("connecting to the database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			log.info("Verifying in the database");
			Query query = session.createQuery("FROM Authentication WHERE role =:role AND email =:email AND password =:password");
			query.setParameter("role", "Admin");
			query.setParameter("email", email );
			query.setParameter("password", password);
			List <Authentication> list;
			list = query.list();
			Iterator iterator = list.iterator();
			
			if(iterator.hasNext()){
				check = "Valid User";
				log.info("User valid");
			}
			else{
				check = "Invalid User";
				log.info("User In valid ");
			}
			transaction.commit();
			
		}catch(HibernateException exception){
			
			log.error("authentication operation failed. Exception occured. "+exception.getMessage());
		}finally{
			session.close();
		}
		return check;
	}
}
