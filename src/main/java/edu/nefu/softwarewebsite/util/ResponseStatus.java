package edu.nefu.softwarewebsite.util;

public enum ResponseStatus {
    SUCCESS(true, 2000, "成功响应"),
    FAIL(false, 4000, "响应失败"),
    ACCOUNT_NOT_LOGIN(false, 5001, "账号未登录");

    private boolean success;
    private int code;
    private String message;

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

    public void setMessage(String message) {
        this.message = message;
    }

    ResponseStatus(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
