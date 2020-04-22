package cn.quellanan.zhulinfeng.mall.login.controller;

import cn.quellanan.zhulinfeng.common.api.CommonResult;
import cn.quellanan.zhulinfeng.mall.login.model.UmsMember;
import cn.quellanan.zhulinfeng.mall.login.service.UserMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserMemberController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/22 9:30
 * @Version 1.0
 */

@Api(tags = "会员用户注册登录")
@RestController
@RequestMapping("/user/member")
public class UserMemberController {

    @Autowired
    private UserMemberService userMemberService;

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<UmsMember> register(@RequestBody UmsMember umsMember, BindingResult result) {
        umsMember = userMemberService.register(umsMember);
        if (umsMember == null) {
            return CommonResult.validateFailed("注册失败，该用户已经注册");
        }
        return CommonResult.success(umsMember);
    }

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsMember umsMember, BindingResult result) {
        umsMember = userMemberService.login(umsMember);
        if (umsMember == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        return CommonResult.success(umsMember);
    }
}
