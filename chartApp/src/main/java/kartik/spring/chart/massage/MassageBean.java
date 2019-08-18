package kartik.spring.chart.massage;

public class MassageBean {
	private String message;
	private String senderUserId;
	private String reciverUserId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(String senderUserId) {
		this.senderUserId = senderUserId;
	}

	public String getReciverUserId() {
		return reciverUserId;
	}

	public void setReciverUserId(String reciverUserId) {
		this.reciverUserId = reciverUserId;
	}

	
	
}
