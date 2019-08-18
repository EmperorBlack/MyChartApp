package kartik.spring.chart.user;

public interface LogInService {

	UserJpa doLogIn(UserBean user);

	String registerUser(UserBean user);

}
