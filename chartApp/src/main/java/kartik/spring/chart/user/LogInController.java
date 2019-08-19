package kartik.spring.chart.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kartik.spring.chart.common.Response;

@RestController
@RequestMapping(value = "/user")
public class LogInController {
	
	@Autowired
	LogInService service;
	
	@Autowired
	Response response;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<Response> userAuthenticate(@RequestBody UserBean user) {
		System.out.println("i am in"+user.getUserName());
		 
		// Map<String ,String> response = new HashMap<String,String>(); 
		// response.put("result", service.doLogIn(user));
		UserJpa LoggedInUser= service.doLogIn(user);
		if(null != LoggedInUser)
			response.buildResponse("success", LoggedInUser);
		else
			response.buildResponse("failed", LoggedInUser);	
		 return new ResponseEntity(response,HttpStatus.OK);
	   
	}
	@RequestMapping(value = "/signUp", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<Map> registerUser(@RequestBody UserBean user) {
		System.out.println("i am in sign Up "+user.getUserName());
		
		 Map<String ,String> response = new HashMap<String,String>(); 
		 response.put("result",service.registerUser(user));
		 return new ResponseEntity(response,HttpStatus.OK);
	   
	}
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<List<UserJpa>> getUserList(@RequestParam String userId) {
		
//		 Map<String ,String> response = new HashMap<String,String>(); 
//		 response.put("result",service.registerUser());
		List<UserJpa> user = service.getUserList(userId);
		if(null != user && user.size() > 1)
			response.buildResponse("success", user);
		else
			response.buildResponse("failed", null);	
		 return new ResponseEntity(response,HttpStatus.OK);
	   
	}
}
//signUp//getUserList