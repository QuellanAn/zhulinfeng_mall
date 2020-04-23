package cn.quellanan.zhulinfeng.mall.login.controller;

import cn.quellanan.zhulinfeng.common.api.CommonResult;
import cn.quellanan.zhulinfeng.mall.login.model.UmsAdmin;
import cn.quellanan.zhulinfeng.mall.login.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserAdminController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/22 9:29
 * @Version 1.0
 */

@Api(tags = "管理员用户注册登录")
@RestController
@RequestMapping("/user/admin")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdmin, BindingResult result) {
        UmsAdmin umsAdmin1 = userAdminService.register(umsAdmin);
        if (umsAdmin1 == null) {
            return CommonResult.validateFailed("注册失败，该用户已经注册");
        }
        return CommonResult.success(umsAdmin1);
    }

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdmin umsAdmin, BindingResult result) {
        UmsAdmin umsAdmin1 = userAdminService.login(umsAdmin.getUsername(),umsAdmin.getPassword());
        if (umsAdmin1 == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        return CommonResult.success(umsAdmin1);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
