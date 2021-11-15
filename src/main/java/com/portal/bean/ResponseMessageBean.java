package com.portal.bean;
/**
 * @author Nitin
 * @created 11/12/2020
 * @modified 
 * @version
 *
 */
public class ResponseMessageBean {

	String failure;
	Integer status;
	String message;
	Object result;
	String code;

	public ResponseMessageBean() {
		super();
	}

	public ResponseMessageBean(Integer status) {
		super();
		this.status = status;
	}

	public ResponseMessageBean(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseMessageBean(Integer status, String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public ResponseMessageBean(String failure, Integer status, String message) {
		super();
		this.failure = failure;
		this.status = status;
		this.message = message;
	}

	public ResponseMessageBean(String failure, Integer status, String message, Object result) {
		super();
		this.failure = failure;
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public ResponseMessageBean(String failure, Object result, String code) {
		super();
		this.failure = failure;
		this.result = result;
		this.code = code;
	}

	public ResponseMessageBean(String failure, Integer status, String message, Object result, String code) {
		super();
		this.failure = failure;
		this.status = status;
		this.message = message;
		this.result = result;
		this.code = code;
	}

	public String getFailure() {
		return failure;
	}

	public void setFailure(String failure) {
		this.failure = failure;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

