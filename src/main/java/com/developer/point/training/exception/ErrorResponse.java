package com.developer.point.training.exception;

/**
 * @author rahul
 *
 */
public class ErrorResponse 
{
    private String message;
    private String status;
    private int code;

	ErrorResponse(){
		
	}
	
	 public ErrorResponse(String message, int code) {
	        super();
	        this.code=code;
	        this.message = message;
	    }
    public ErrorResponse(String message,String status, int code) {
        super();
        this.status=status;
        this.code=code;
        this.message = message;
    }
 
 
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}


 
}