package com.pinyougou.user.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.pinyougou.common.core.controller.BaseController;

import java.security.Principal;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xuzilou
 * @since 2019-02-01
 */
@RestController
@RequestMapping("/user")
@Api(value = "WEB - UserController", tags = "用户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TbUserController extends BaseController {

    @GetMapping("")
    @ApiOperation(httpMethod = "GET", value = "获取用户信息")
    public Principal user(Principal user) {
        logger.info("获取用户信息:{}", user.getName());
        return user;
    }
}
