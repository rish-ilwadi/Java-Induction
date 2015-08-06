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
 * public class AddressDAO
 * DAO class for Address table
 */
public class AddressDAO {
	/*
	 * Data Members
	 */
	private Configuration config;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	private Logger log;
	public AddressDAO(){
		log = Logger.getLogger(AddressDAO.class);
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
	}
	/*
	 * public String addEntry(String fname, String lname, long phoneNo, String address, String email)
	 * Used for adding entries to the Address Table
	 */
	public String addEntry(String fname, String lname, long phoneNo, String address, String email){
		
		String check = null;
		log.debug("Entering addEntry()");
		try{
			log.info("Connecting to the database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			Address newAddress = new Address();
			newAddress.setFname(fname);
			newAddress.setLname(lname);
			newAddress.setPhoneNo(phoneNo);
			newAddress.setAddress(address);
			newAddress.setEmail(email);
			
			session.persist(newAddress);
			log.info("entry added");
			check = "Done";
			transaction.commit();
			
		}catch(HibernateException exception){
			check = "error";
			log.error("entry failed. Exception occured. "+exception.getMessage());
			
		}finally{
			session.close();
		}
		return check;
	}
	/*
	 * public int removeEntry(String fname, String lname, String email)
	 * Used for removing a particular entry from the Address table
	 */
	public int removeEntry(String fname, String lname, String email){
		int check =0;
		log.debug("Entering removeEntry()");
		try{
			log.info("connecting to the database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			log.info("removing entry");
			Query query = session.createQuery("DELETE FROM Address WHERE fname =:fname AND lname =:lname AND email =:email");
			query.setParameter("fname", fname);
			query.setParameter("lname", lname);
			query.setParameter("email", email);
			check = query.executeUpdate();
			transaction.commit();
			log.info("entry removed");
		}catch(HibernateException exception){
			
			log.error("entry remove operation failed. Exception occured. "+exception.getMessage());
		}finally{
			session.close();
		}
		return check;
	}
	/*
	 * public Address getEntry(String fname, String lname, String email)
	 * Used for getting details of a particular entry from Address Table
	 */
	public Address getEntry(String fname, String lname, String email){
		
		Address address = null;
		log.debug("entering getEntry()");
		try{
			log.info("connecting to the database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			log.info("searching");
			Query query = session.createQuery(" FROM Address WHERE fname =:fname AND lname =:lname AND email =:email");
			query.setParameter("fname", fname);
			query.setParameter("lname", lname);
			query.setParameter("email", email);
			List <Address> list;
			list = query.list();
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				address =(Address)iterator.next();
			}
			transaction.commit();
			log.info("search complete");
		}catch(HibernateException exception){
			log.error("get entry operation failed. Exception occured. "+exception.getMessage());
			
		}finally{
			session.close();
		}
		return address;
	}
	/*
	 * public List searchEntry(String search)
	 * Used for searching according to the first name in the Address Table & returning the records in the form of List
	 */
	public List searchEntry(String search, String sortBy){
		
		log.debug("entering searchEntry()");
		List <Address> list= null;
		try{
			log.info("connecting to the database");
			config = new Configuration();
			factory = config.configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			log.info("searching");
			Query query = session.createQuery("FROM Address WHERE fname LIKE :fname ORDER BY "+sortBy);
			query.setString("fname", search + '%');
	
			list = query.list();
			
			transaction.commit();
			log.info("search complete");
		}catch(HibernateException exception){
			
			log.error("search operation failed. Exception occured. "+exception.getMessage());
		}finally{
			session.close();
		}
		return list;
	}
}
