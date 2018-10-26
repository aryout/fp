package com.fintell.fp.service.impl;

import com.fintell.fp.constant.CapitalOrg;
import com.fintell.fp.constant.LoanMarket;
import com.fintell.fp.mapper.UserMapper;
import com.fintell.fp.service.UserService;
import com.fintell.fp.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 10:40 2018/10/25
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User registerUser(User applyUser, String org, String from) {
        User existUser = getUserByName(applyUser.getName());
        User resultUser = null;

        if (existUser == null){
            // 用户没在流量平台上注册过
            log.info("用户:{} 没在流量平台上注册过",applyUser.getName());
        }else if (!isUserRegistCapitalOrg(existUser, org)){
            // 用户没从流量平台在指定资方机构注册过（即，不包含机构自有用户表）
            log.info("用户:{} 没从流量平台在指定资方机构: {} 注册过", existUser.getName(), org);
        }else {
            // 用户已经注册过资方机构（通过流量平台注册）
            org = null;
        }
        resultUser = mergeUserInfo(applyUser, existUser);
        resultUser = doRegisterUser(resultUser, org, from);
        return resultUser;
    }

    /**
     *  合并新旧用户信息，执行合并策略
     *
     * @param: applyUser 导入用户时提交的用户信息
     * @param: existUser 流量平台已存在的用户信息
     * @return
     * @author chen dao peng
     * @date 2018/10/25
     */
    private User mergeUserInfo(User applyUser, User existUser){
        if (existUser == null){
            return applyUser;
        }
        User newUser = new User();
        // TODO 执行合并用户信息策略
        return newUser;
    }

    /**
     * 将资方机构和来源机构填入用户信息中
     * @param user 合并新旧信息后的用户信息
     * @param org  用户将要注册的资方机构
     * @param from  用户来源渠道
     * @return
     */
    private User doRegisterUser(User user, String org, String from){
        if (org != null){
            // 更新注册机构
            user.getCapitalOrgs().add(CapitalOrg.fromCOInfo(org));
        }

        // 更新客户来源
        if (!isUserRegistLoanMarket(user, from)){
            user.getLoanMarkets().add(LoanMarket.fromLMInfo(from));
        }
        user = updateUser(user);
        return user;
    }

    @Override
    public User updateUser(User user){
        if (userMapper.updateUserByTotal(user) < 0){
            return null;
        }
        return user;
    }

    @Override
    public User getUserByName(String username) {
        User user = userMapper.queryUserByName(username);
        return user;
    }

    @Override
    public boolean isUserRegistCapitalOrg(User inUser, String capitalOrg) {
        return inUser.getCapitalOrgs().contains(CapitalOrg.fromCOInfo(capitalOrg));
    }

    @Override
    public boolean isUserRegistLoanMarket(User inUser, String loanMarket) {
        return inUser.getLoanMarkets().contains(CapitalOrg.fromCOInfo(loanMarket));
    }
}
