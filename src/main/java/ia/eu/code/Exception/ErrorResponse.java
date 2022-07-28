package ia.eu.code.Exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {
    String Message;
    String StatusCode;
    Date time;
    List<String> details;

    public ErrorResponse(String message, String statusCode, List<String> details) {
        Message = message;
        StatusCode = statusCode;
        this.details = details;
        this.time= new Date();
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
