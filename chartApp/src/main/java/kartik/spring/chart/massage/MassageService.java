package kartik.spring.chart.massage;

import java.util.List;

public interface MassageService {
	
	public void addChat(String message,Long senderUserId,Long reciverUserId) ;
	public List<MassageBean> getMessageas(Long senderUserId,Long reciverUserId);
}
