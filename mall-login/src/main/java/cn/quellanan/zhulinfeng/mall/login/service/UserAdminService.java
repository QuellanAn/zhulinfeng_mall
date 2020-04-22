package cn.quellanan.zhulinfeng.mall.login.service;

import cn.quellanan.zhulinfeng.mall.login.model.UmsAdmin;

/**
 * @ClassName UserAdminService
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/22 9:31
 * @Version 1.0
 */
public interface UserAdminService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    UmsAdmin login(String username,String password);

    /**
     * 管理员注册
     * @param umsAdmin
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdmin);
}
