package com.fintell.fp.vo;

import com.fintell.fp.constant.CapitalOrg;
import com.fintell.fp.constant.LoanMarket;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 20:18 2018/10/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
/*@Entity
@Table(name = "t_user")*/
public class User {
    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(hidden = true)
    private String password;

    @ApiModelProperty(value = "用户已注册的资方机构列表")
    private List<CapitalOrg> capitalOrgs;

    @ApiModelProperty(value = "导入该用户的渠道机构列表")
    private List<LoanMarket> loanMarkets;
}

/*    CREATE TABLE IF NOT EXISTS `t_user`(
        `name` VARCHAR(50) NOT NULL,
        `iscard` VARCHAR(100),
        `password` VARCHAR(40),
        PRIMARY KEY ( `name` )
        )ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
