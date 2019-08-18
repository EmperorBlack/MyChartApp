package kartik.spring.chart.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInServiceImpl implements LogInService{

	@Autowired
	LogInDao dao;
	public UserJpa doLogIn(UserBean user) {
		
		return dao.doLogIn(user);
	}
	public String registerUser(UserBean user) {
		boolean isUserExist =  dao.checkUserUniqueness(user.getUserName());
			if(isUserExist)
				return "userExist";
			else
				return dao.registerUser(user);
	}

}
