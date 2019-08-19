package kartik.spring.chart.massage;

import java.util.List;

public interface MassageDao {
//	@Transactional(readOnly  = true)
	public String addMessage(MassageBean msg) ;
	
	public List<MassageJpa> getMessageas(Long senderUserId,Long reciverUserId);
}