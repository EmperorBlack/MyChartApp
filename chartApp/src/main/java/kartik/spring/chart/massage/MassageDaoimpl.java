package kartik.spring.chart.massage;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import kartik.spring.chart.hibernateConfig.HibernateConfig;

public class MassageDaoimpl implements MassageDao {
	
	Session session;
	Transaction transaction = null;
	public MassageDaoimpl() {
		session = HibernateConfig.getSessionFactory().openSession();
	}

	public void addMessage(String message,Long senderUserId,Long reciverUserId) {
		MassageJpa m=new MassageJpa();
		m.setSenderUserId(senderUserId);
		m.setReciverUserId(reciverUserId);
		m.setMsgContent(message);
	    Date date = new Date();
	    m.setDateTime(date);
		 try  {
			 transaction = session.beginTransaction();
	            session.save(m);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<MassageBean> getMessageas(Long senderUserId,Long reciverUserId){
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from MessageJpa where senderUserId=:senderUserId and reciverUserId=:reciverUserId order by dateTime desc").setMaxResults(10);
		query.setParameter("reciverUserId", reciverUserId);
		query.setParameter("senderUserId", senderUserId);
		List<MassageBean> messages=query.getResultList();
		return messages;
	}
}