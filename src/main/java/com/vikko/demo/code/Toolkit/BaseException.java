package com.vikko.demo.code.Toolkit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -743309525085095430L;
	protected ErrorCode errorCode;
	protected String code;
	protected String message;

	public BaseException(ErrorCode errorCode) {
		this.code = errorCode.getErrorCode();
		this.message = errorCode.getMessage();
		this.errorCode = errorCode;
	}

	public BaseException(String code,String message) {
		this.code = code;
		this.message = message;
		this.errorCode = new ErrorCode() {
			@Override
			public String getErrorCode() {
				return code;
			}

			@Override
			public String getMessage() {
				return message;
			}
		};
	}


}
