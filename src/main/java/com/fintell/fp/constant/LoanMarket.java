package com.fintell.fp.constant;

import com.fintell.fp.excetion.DescribeException;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 12:32 2018/10/25
 **/
public enum LoanMarket {
    /**
     * 拉卡拉
     */
    LAKALA("拉卡拉", "LM000001");

    private static final String prefix = "LM";

    /**
     *  贷超名称
     */
    private String LM_Name;

    /**
     *  贷超代码
     */
    private String LM_Code;

    LoanMarket(String LM_Name,String LM_Code) {
        this.LM_Name = LM_Name;
        if (LM_Code.startsWith(prefix)){
            this.LM_Code = LM_Code;
        }else {
            this.LM_Code = prefix + LM_Code;
        }
    }

    /**
     * 返回贷超实例
     * @param LMInfo 贷超名称或代码
     * @return
     */
    public static LoanMarket fromLMInfo(String LMInfo){
        if (LMInfo.startsWith(prefix)){
            return fromLMCode(LMInfo);
        }else {
            return fromLMName(LMInfo);
        }
    }

    /**
     * 根据贷超名称，返回贷超的枚举实例。
     *
     * @param LM_Name 贷超名称
     */
    private static LoanMarket fromLMName(String LM_Name) {
        for (LoanMarket loanMarket : LoanMarket.values()) {
            if (loanMarket.getLMName().equals(LM_Name)) {
                return loanMarket;
            }
        }
        DescribeException noSatisfiedLoanMarketFound = new DescribeException("No Satisfied LoanMarket Found For LM_Name: "+ LM_Name);
        // noSatisfiedLoanMarketFound.setCode();
        throw noSatisfiedLoanMarketFound;
    }

    /**
     * 根据贷超代码，返回贷超的枚举实例。
     *
     * @param LM_Code 贷超代码
     */
    private static LoanMarket fromLMCode(String LM_Code) {
        for (LoanMarket loanMarket : LoanMarket.values()) {
            if (loanMarket.getLMCode().equals(LM_Code)) {
                return loanMarket;
            }
        }
        DescribeException noSatisfiedLoanMarketFound = new DescribeException("No Satisfied LoanMarket Found For LM_Code: "+ LM_Code);
        // noSatisfiedLoanMarketFound.setCode();
        throw noSatisfiedLoanMarketFound;
    }

    public String getLMName() {
        return this.LM_Name;
    }

    public String getLMCode() {
        return this.LM_Code;
    }

    public static String getPrefix() {
        return prefix;
    }
}
