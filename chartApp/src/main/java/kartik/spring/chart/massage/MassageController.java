package kartik.spring.chart.massage;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chat")

public class MassageController {
	
	MassageService massageService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public void addMessage(@RequestParam("massage") String message,@RequestParam("senderId") String senderId,@RequestParam("reciverId") String reciverId) {
		massageService.addChat(message,Long.parseLong(senderId), Long.parseLong(reciverId));
		   
	}
	
	@RequestMapping(value = "/getMsg", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public void getMsg(@RequestParam("senderId") String senderId,@RequestParam("reciverId") String reciverId) {
		massageService.getMessageas(Long.parseLong( senderId), Long.parseLong(reciverId));
		   
	}

}
