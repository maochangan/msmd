package net.msmd.api.bean.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoBO implements Serializable {

    private static final long serialVersionUID = -1104002436418321862L;

    private Integer id;

    private String userName;

    private String userAccount;

    private Integer userAge;

    private Integer userSex;

    private String headImgUrl;

    private Integer userType;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;




}
