package kartik.spring.chart.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER")
public class UserJpa {

	private String userName ;
	private String password;
	
}
