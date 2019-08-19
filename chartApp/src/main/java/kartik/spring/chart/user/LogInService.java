package kartik.spring.chart.user;

import java.util.List;

public interface LogInService {

	UserJpa doLogIn(UserBean user);

	String registerUser(UserBean user);

	List<UserJpa> getUserList(String userId);

}
