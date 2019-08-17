package kartik.spring.chart.user;


import org.hibernate.Session;
import org.hibernate.Transaction;
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
		 UserJpa u = new UserJpa();
		 u.setUserName("kartik");
		 u.setPassword("kartik@123");
	        try  {
	            transaction = session.beginTransaction();
	            session.save(u);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return u.getUserId().toString();
	}

}
