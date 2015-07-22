package hibernate;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO {

	public int addUser(String name, String email, String password){
		
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
		
			SignUpDB client=new SignUpDB();
			client.setName(name);
			client.setEmail(email);
			client.setPassword(password);
		
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
			Query logInQuery= session.createQuery("from SignUpDB where email=:email AND password=:password");
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
