package com.fintell.fp.constant;

import com.fintell.fp.excetion.DescribeException;

/**
 * @author chen dao peng
 * @program fp
 * @description 资方机构配置
 * @date 11:03 2018/10/25
 **/
public enum CapitalOrg {
    /**
     * 锦程
     */
    JINCHENG("锦程", "CO000001");


    /**
     * 代码前缀
     */
    private static final String prefix = "CO";

    /**
     *  机构名称
     */
    private String CO_Name;

    /**
     *  机构代码
     */
    private String CO_Code;

    CapitalOrg(String orgName,String orgCode) {
        this.CO_Name = orgName;
        if (orgCode.startsWith(prefix)){
            this.CO_Code = orgCode;
        }else {
            this.CO_Code = prefix + orgCode;
        }
    }

    /**
     * 返回机构实例
     * @param COInfo 机构名称或代码
     * @return
     */
    public static CapitalOrg fromCOInfo(String COInfo){
        if (COInfo.startsWith(prefix)){
            return fromCOCode(COInfo);
        }else {
            return fromCOName(COInfo);
        }
    }

    /**
     * 根据机构名称，返回机构的枚举实例。
     *
     * @param CO_Name 机构名称
     */
    private static CapitalOrg fromCOName(String CO_Name) {
        for (CapitalOrg capitalOrg : CapitalOrg.values()) {
            if (capitalOrg.getCOName().equals(CO_Name)) {
                return capitalOrg;
            }
        }
        DescribeException noSatisfiedCapitalOrgFound = new DescribeException("No Satisfied CapitalOrg Found For CO_Name: "+CO_Name);
        // noSatisfiedCapitalOrgFound.setCode();
        throw noSatisfiedCapitalOrgFound;
    }

    /**
     * 根据机构代码，返回机构的枚举实例。
     *
     * @param CO_Code 机构代码
     */
    private static CapitalOrg fromCOCode(String CO_Code) {
        for (CapitalOrg capitalOrg : CapitalOrg.values()) {
            if (capitalOrg.getCOCode().equals(CO_Code)) {
                return capitalOrg;
            }
        }
        DescribeException noSatisfiedCapitalOrgFound = new DescribeException("No Satisfied CapitalOrg Found For CO_Code: "+CO_Code);
        // noSatisfiedCapitalOrgFound.setCode();
        throw noSatisfiedCapitalOrgFound;
    }

    public String getCOName() {
        return this.CO_Name;
    }

    public String getCOCode() {
        return this.CO_Code;
    }

    public static String getPrefix() {
        return prefix;
    }
}