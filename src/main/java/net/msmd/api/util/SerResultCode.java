package net.msmd.api.util;


public enum SerResultCode {
    //业务编码信息
    SUCCESS("业务操作成功", 1),
    FAIL("业务操作失败", 0),
    ERROR("系统异常", -1);

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    SerResultCode(String value, int code) {
        this.code = code;
        this.msg = value;
    }
}