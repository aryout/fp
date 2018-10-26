package com.fintell.fp.controller.rest;

import com.fintell.fp.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 20:53 2018/10/24
 **/
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
@Api(description = "用户管理")
public class UserController {

    ArrayList<User> users = new ArrayList<>();


    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public List<User> add() {
        users.add(new User());
        users.add(new User());
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User postUser(User user) {
        // service
        return user;
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User getUser(@ApiParam(value = "用户id", required = true)
                        @PathVariable(value = "id") String id) {

        return new User();
    }
}
