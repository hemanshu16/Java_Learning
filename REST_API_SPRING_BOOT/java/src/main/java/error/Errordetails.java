package error;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Errordetails {
      public LocalDateTime timestamp;
      public String message;
      public String details;
      
	public Errordetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.timestamp = localDateTime;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Errordetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

      
      
}
