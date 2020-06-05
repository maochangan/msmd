package net.msmd.api.bean;

import lombok.Data;

@Data
public class UserInfo {

    private Integer id;

    private String userName;

    private Integer userAge;

    private String password;

    private String gmtCreateTime;

    private String gmtModifiedTime;

    private Integer status;


}
