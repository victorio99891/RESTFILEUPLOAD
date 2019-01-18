package pl.wiktor.response;

import org.springframework.http.HttpStatus;

public class CustomResponse {

    private String message;
    private int status_code;
    private String status;

    public CustomResponse(String message, HttpStatus status) {
        this.message = message;
        this.status_code = status.value();
        this.status = status.name();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
