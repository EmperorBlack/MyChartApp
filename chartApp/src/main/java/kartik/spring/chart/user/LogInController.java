package kartik.spring.chart.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class LogInController {
	
	@Autowired
	LogInService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public void userAuthenticate(@RequestBody UserBean user) {
		System.out.println("i am in"+user.getUserName());
//		 ModelAndView mav = new ModelAndView("new1"); 
		String Result = service.doLogIn(user);
		
		   
	}
}
