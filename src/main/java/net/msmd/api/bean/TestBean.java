package net.msmd.api.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestBean implements Serializable {

    private static final long serialVersionUID = 4162167037196085292L;

    private Integer userID;

    private String userName;

    private String password;

    private Integer userAge;

    private String gmtCreateTime;

    private String gmtModifiedTime;

    private Integer status;


}
