package net.msmd.api.bean.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginUserVO implements Serializable {

    private static final long serialVersionUID = -5498597107052002797L;

    @NotNull(message = "account can't be null")
    private String userAccount ;

    @NotEmpty(message = "password can't be null")
    private String userPassword;


}
