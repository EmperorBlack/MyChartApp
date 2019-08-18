package kartik.spring.chart.common;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private String msg;
	private Object result;
	public void buildResponse(String msg,Object result) {
		
		this.msg=msg;
		this.result=result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
