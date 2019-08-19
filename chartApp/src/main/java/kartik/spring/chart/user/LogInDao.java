package kartik.spring.chart.user;

import java.util.List;

public interface LogInDao {

	UserJpa doLogIn(UserBean user);

	String registerUser(UserBean user);

	boolean checkUserUniqueness(String userName);

	List<UserJpa> getUsers(String userId);

}
