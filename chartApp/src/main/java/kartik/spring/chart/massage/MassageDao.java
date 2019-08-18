package kartik.spring.chart.massage;

import java.util.List;

public interface MassageDao {
//	@Transactional(readOnly  = true)
	public void addMessage(String message,Long senderUserId,Long reciverUserId) ;
	
	public List<MassageBean> getMessageas(Long senderUserId,Long reciverUserId);
}