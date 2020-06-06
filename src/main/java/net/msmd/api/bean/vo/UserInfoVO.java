package net.msmd.api.bean.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserInfoVO implements Serializable {

    private static final long serialVersionUID = -8436527761750383856L;

    @NotNull(message = "id can't be null")
    private Integer id;

    @NotEmpty(message = "user name can't be null")
    private String userName;

}
