package kartik.spring.chart.user;

public interface LogInDao {

	UserJpa doLogIn(UserBean user);

	String registerUser(UserBean user);

	boolean checkUserUniqueness(String userName);

}
