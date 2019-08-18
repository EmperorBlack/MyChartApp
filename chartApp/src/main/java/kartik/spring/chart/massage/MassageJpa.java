package kartik.spring.chart.massage;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MSG")

public class MassageJpa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MSG_ID")
	private Long msgId;
	@Column(name = "MSG_CONTENT")
	private String msgContent;
	@Column(name = "SENDER_USER_ID")
	private Long senderUserId;
	@Column(name = "RECIVER_USER_ID")
	private Long reciverUserId;
	
	@Column(name = "DATE_TIME")
	private Date dateTime;
	

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Long getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(Long senderUserId) {
		this.senderUserId = senderUserId;
	}

	public Long getReciverUserId() {
		return reciverUserId;
	}

	public void setReciverUserId(Long reciverUserId) {
		this.reciverUserId = reciverUserId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	

}
