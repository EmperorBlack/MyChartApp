package kartik.spring.chart.massage;


import java.util.List;

public class MassageServiceImpl implements MassageService {
	
	public MassageDao massageDao;
	
	public void addChat(String message,Long senderUserId,Long reciverUserId) {
		massageDao.addMessage(message, senderUserId, reciverUserId);
	}
	
	public List<MassageBean> getMessageas(Long senderUserId,Long reciverUserId){
		return massageDao.getMessageas(senderUserId, reciverUserId);
	}
}