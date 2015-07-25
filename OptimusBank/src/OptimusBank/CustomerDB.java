package OptimusBank;

import OptimusBank.Customer;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerDB {

public int addUser(String customerName, String email, String password, char gender, String address, String city, String state, String pin, String fax, String telephoneNo, Date dateOfBirth){
		
		int check=0;
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction transaction=null;
		try{
			config=new Configuration();
			config.configure("hibernate.cfg.xml");
		
			factory=config.buildSessionFactory();
		
			session=factory.openSession();
		
			transaction=session.beginTransaction();
		
			Customer client=new Customer();
			client.setCustomerName(customerName);
			client.setEmail(email);
			client.setPassword(password);
			client.setGender(gender);
			client.setAddress(address);
			client.setCity(city);
			client.setState(state);
			client.setDateOfBirth(dateOfBirth);
			client.setFax(fax);
			client.setPin(pin);
			client.setTelephoneNo(telephoneNo);
		
			check=(int) session.save(client);
			transaction.commit();
		
		}catch(HibernateException exception){
			exception.printStackTrace();
		}
		finally{
			session.close();
			return check;
		}
			   
	}
	public int checkLogIn(String email,String password){
	
		int check=0;
		Configuration config=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction transaction=null;
		
		try{
		
			config=new Configuration();
			config.configure("hibernate.cfg.xml");
		
			factory=config.buildSessionFactory();
		
			session=factory.openSession();
		
			transaction=session.beginTransaction();
			Query logInQuery= session.createQuery("from UserDetails where email=:email AND password=:password");
			logInQuery.setParameter("email", email);
			logInQuery.setParameter("password", password);
			List list;
			list=logInQuery.list();
			
			if(list.size() > 0){
				check=1;
			}
			
			transaction.commit();
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			
			session.close();
			return check;
		}
		
	}
}
