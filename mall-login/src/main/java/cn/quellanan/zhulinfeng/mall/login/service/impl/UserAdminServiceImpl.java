package cn.quellanan.zhulinfeng.mall.login.service.impl;

import cn.quellanan.zhulinfeng.mall.login.mapper.UmsAdminMapper;
import cn.quellanan.zhulinfeng.mall.login.model.UmsAdmin;
import cn.quellanan.zhulinfeng.mall.login.model.UmsAdminExample;
import cn.quellanan.zhulinfeng.mall.login.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/21 14:22
 * @Version 1.0
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {


    @Autowired
    private UmsAdminMapper userMapper;

    @Override
    public UmsAdmin login(String username, String password) {
        UmsAdmin umsAdmin=null;
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<UmsAdmin> list= userMapper.selectByExample(umsAdminExample);
        if(!list.isEmpty()){
             umsAdmin=list.get(0);
             umsAdmin.setLoginTime(new Date());
             userMapper.updateByPrimaryKey(umsAdmin);
        }
        return umsAdmin;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        umsAdmin.setCreateTime(new Date());
        UmsAdminExample umsAdminExample=new UmsAdminExample();
        umsAdminExample.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> list= userMapper.selectByExample(umsAdminExample);
        if(!list.isEmpty()){
            return null;
        }else {
            userMapper.insert(umsAdmin);
        }
        return umsAdmin;
    }
}
