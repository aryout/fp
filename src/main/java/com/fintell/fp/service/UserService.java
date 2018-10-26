package com.fintell.fp.service;

import com.fintell.fp.vo.User;

/**
 * @@author chen dao peng
 * @program fp
 * @description
 * @date 10:39 2018/10/25
 **/
public interface UserService {
    /**
     *  新用户注册
     *
     * @param: user 导入的用户
     * @param: org  用户注册机构
     * @param: from  用户来源渠道
     * @return user
     * @author chen dao peng
     * @date 2018/10/25
     */
    User registerUser(User user, String org, String from);

    /**
     *  返回指定注册用户
     *
     * @param: username  用户名字
     * @return user
     * @author chen dao peng
     * @date 2018/10/25
     */
    User getUserByName(String username);


    /**
     *  注册用户时，更新用户信息
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 用户是否注册了资方机构
     *
     * @param: user 用户
     * @param: org 资方机构名字
     * @return boolean
     * @author chen dao peng
     * @date 2018/10/25
     */
    boolean isUserRegistCapitalOrg(User user, String capitalOrg);

    /**
     * 用户是否注册了贷超机构
     *
     * @param: user 用户
     * @param: org 贷超机构名字
     * @return boolean
     * @author chen dao peng
     * @date 2018/10/25
     */
    boolean isUserRegistLoanMarket(User user, String loanMarket);
}
