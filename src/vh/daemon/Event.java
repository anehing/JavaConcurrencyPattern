package vh.daemon;

import java.util.Date;

/**
 * @author ane
 *
 * @version 2:23:06 PM 2015
 *
 */
public class Event {
	private Date date;
	private String event;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
