package kartik.spring.chart.massage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import kartik.spring.chart.hibernateConfig.HibernateConfig;

@Repository
public class MassageDaoimpl implements MassageDao {
	
	Session session;
	Transaction transaction = null;
	public MassageDaoimpl() {
		session = HibernateConfig.getSessionFactory().openSession();
	}

	public String addMessage(MassageBean msg) {
		MassageJpa msgInfo=new MassageJpa();
		msgInfo.setSenderUserId(Long.parseLong(msg.getSenderUserId()));
		msgInfo.setReciverUserId(Long.parseLong(msg.getReciverUserId()));
		msgInfo.setMsgContent(msg.getMessage());
		msgInfo.setMsgOwner(Long.parseLong(msg.getSenderUserId()));
	    Date date = new Date();
	    msgInfo.setDateTime(date);
		 try  {
			 transaction = session.beginTransaction();
	            session.save(msgInfo);
	            transaction.commit();
	            if(msgInfo.getMsgId()!=null)
	            	return "success";
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return "failed";
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<MassageJpa> getMessageas(Long senderUserId,Long reciverUserId){
		List<Long> ids = new ArrayList<Long>();
		ids.add(senderUserId);
		ids.add(reciverUserId);
		List<MassageJpa> messages = null;
		try  {
			 transaction = session.beginTransaction();
			 Query query=session.createQuery("from MassageJpa where senderUserId IN :senderUserId and reciverUserId IN :reciverUserId order by dateTime desc").setMaxResults(5);
				query.setParameter("reciverUserId", ids);
				query.setParameter("senderUserId", ids);
				 messages=query.getResultList();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return messages;
	}
}