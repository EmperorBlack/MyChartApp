package kartik.spring.chart.massage;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MassageServiceImpl implements MassageService {
	
	@Autowired
	MassageDao massageDao;
	
	public String addChat(MassageBean msg) {
		return massageDao.addMessage(msg);
	}
	
	public List<MassageJpa> getMessageas(Long senderUserId,Long reciverUserId){
		return massageDao.getMessageas(senderUserId, reciverUserId);
	}
}