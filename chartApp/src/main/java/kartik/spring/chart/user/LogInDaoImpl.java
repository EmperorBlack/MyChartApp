package kartik.spring.chart.user;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import kartik.spring.chart.hibernateConfig.HibernateConfig;

@Repository
public class LogInDaoImpl implements LogInDao{
	
	Session session;
	public LogInDaoImpl() {
		session = HibernateConfig.getSessionFactory().openSession();
	}

	public String doLogIn(UserBean user) {
		
		 Transaction transaction = null;
	        try  {
	            transaction = session.beginTransaction();
	            Query query = session.createQuery("from UserJpa where userName =:userName and password =:password");
	            query.setParameter("userName", user.getUserName());
	            query.setParameter("password", user.getPassword());
	            List<UserJpa> result= query.getResultList();
	            transaction.commit();
	            if(result != null && result.size() > 0)
	            	return "success";
	            else
	            	return "failed";	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return "failed";
	}

	public String registerUser(UserBean user) {
		Transaction transaction = null;
			UserJpa newUser = new UserJpa();
			newUser.setUserName(user.getUserName());
			newUser.setPassword(user.getPassword());
        try  {
            transaction = session.beginTransaction();
             session.save(newUser);
             
             transaction.commit();
             if(newUser.getUserId() != null)
            	 return "success";
             else
            	 return "failed";
            	           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return "failed";
	}

	public boolean checkUserUniqueness(String userName) {
		
		 Transaction transaction = null;
		        try  {
		            transaction = session.beginTransaction();
		            Query query = session.createQuery("from UserJpa where userName =:userName");
		            query.setParameter("userName", userName);
		            List<UserJpa> result= query.getResultList();
		            transaction.commit();
		            if(result != null && result.size() > 0)
		            	return true;
		            else
		            	return false;	           
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		        }
		        return false;
	}

}
