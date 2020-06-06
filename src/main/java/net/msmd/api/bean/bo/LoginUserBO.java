package net.msmd.api.bean.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserBO implements Serializable {

    private static final long serialVersionUID = -5498597107052002797L;

    private Integer id;

    private String userName;

    private String userAccount;

    private String password;

}
