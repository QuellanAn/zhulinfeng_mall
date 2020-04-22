package cn.quellanan.zhulinfeng.mall.login.service;

import cn.quellanan.zhulinfeng.mall.login.model.UmsMember;

public interface UserMemberService {


    /**
     * 会员登录
     * @param umsMember
     * @return
     */
    UmsMember login(UmsMember umsMember);

    /**
     * 会员注册
     * @param umsMember
     * @return
     */
    UmsMember register(UmsMember umsMember);
}
