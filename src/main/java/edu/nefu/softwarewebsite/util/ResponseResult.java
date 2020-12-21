package edu.nefu.softwarewebsite.util;

public class ResponseResult {
    private boolean success;
    private int code;
    private String message;
    private Object data;

    public ResponseResult(boolean success, int code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(ResponseStatus responseStatus) {
        this.success = responseStatus.isSuccess();
        this.code = responseStatus.getCode();
        this.message = responseStatus.getMessage();
        this.data = null;
    }

    public static ResponseResult successResponse() {
        return new ResponseResult(ResponseStatus.SUCCESS);
    }

    public static ResponseResult failResponse() {
        return new ResponseResult(ResponseStatus.FAIL);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }
}
