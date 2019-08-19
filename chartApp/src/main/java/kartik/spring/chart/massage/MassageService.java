package kartik.spring.chart.massage;

import java.util.List;

public interface MassageService {
	
	public String addChat(MassageBean msg) ;
	public List<MassageJpa> getMessageas(Long senderUserId,Long reciverUserId);
}
