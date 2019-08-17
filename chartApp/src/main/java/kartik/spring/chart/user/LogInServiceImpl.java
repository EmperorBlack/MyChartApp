package kartik.spring.chart.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInServiceImpl implements LogInService{

	@Autowired
	LogInDao dao;
	public String doLogIn(UserBean user) {
		
		return dao.doLogIn(user);
	}

}
