package coms309.demo2.model;
import javax.persistence.*;
@Entity
@Table(name="visits")
public class CalendarEvent 
{
	@Id
	@Column(nullable=false, length = 20)
	private String docName; // only last needed
	
	@Column(nullable=false, length = 20)
	private String date; // only last needed

	@Column(nullable=false, length = 20)
	private String time; // only last needed
	
	@Column(nullable=false, length = 20)
	private String reason; // only last needed
	
	public String getDocName()
	{
		return docName;
	}
	
	public void setDocName(String docName)
	{
		this.docName = docName;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}

	public String getReason()
	{
		return reason;
	}
	
	public void setReason(String reason)
	{
		this.reason = reason;
	}
}
