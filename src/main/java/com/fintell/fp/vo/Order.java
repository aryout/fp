package com.fintell.fp.vo;

import com.fintell.fp.constant.CapitalOrg;
import com.fintell.fp.constant.LoanMarket;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 13:32 2018/10/25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Order {
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "乙方：订单用户信息")
    private User user;

    @ApiModelProperty(value = "甲方：订单资方")
    private CapitalOrg capitalOrg;

    @ApiModelProperty(value = "订单来源")
    private LoanMarket loanMarket;

    @ApiModelProperty(value = "订单信息")
    private OrderDetail orderDetail;

    public void setCapitalOrg(String capitalOrgInfo) {
        capitalOrg = CapitalOrg.fromCOInfo(capitalOrgInfo);
        if (capitalOrg == null){
            log.error("Order error: No satisfied capitalOrg for order by capitalOrgInfo: {}",capitalOrgInfo);
        }
    }

    public void setLoanMarket(String loanMarketInfo) {
        loanMarket = LoanMarket.fromLMInfo(loanMarketInfo);
        if (loanMarket == null){
            log.error("Order error: No satisfied loadMarket for order by loanMarketInfo: {}",loanMarketInfo);
        }
    }
}
