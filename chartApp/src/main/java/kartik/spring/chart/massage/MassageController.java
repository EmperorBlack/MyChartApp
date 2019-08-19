package kartik.spring.chart.massage;


import java.util.List;

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
@RequestMapping(value = "/massage")

public class MassageController {
	
	@Autowired
	MassageService massageService;
	
	@Autowired
	Response response;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<Response> addMessage(@RequestBody MassageBean msg) {
		String result = massageService.addChat(msg);
		if(result.equalsIgnoreCase("success"))
			response.buildResponse(result, "added successfully");
		else
			response.buildResponse(result, "failled to add");
		 return new ResponseEntity(response,HttpStatus.OK);
	   
	}
	
	@RequestMapping(value = "/getMsgs", method = RequestMethod.POST ,produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<MassageJpa> getMsg(@RequestParam("reciverId") String reciverId,@RequestParam("senderId") String senderId) {
		List<MassageJpa> msgs = massageService.getMessageas(Long.parseLong( senderId), Long.parseLong(reciverId));
		if(null != msgs)
			response.buildResponse("success", msgs);
		else
			response.buildResponse("no chat yet", msgs);	
		 return new ResponseEntity(response,HttpStatus.OK);
		   
	}

}
