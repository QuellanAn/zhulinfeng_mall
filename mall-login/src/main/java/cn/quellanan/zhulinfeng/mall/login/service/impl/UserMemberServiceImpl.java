package cn.quellanan.zhulinfeng.mall.login.service.impl;

import cn.quellanan.zhulinfeng.mall.login.mapper.UmsMemberMapper;
import cn.quellanan.zhulinfeng.mall.login.model.UmsMember;
import cn.quellanan.zhulinfeng.mall.login.model.UmsMemberExample;
import cn.quellanan.zhulinfeng.mall.login.service.UserMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserMemberServiceImpl
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/22 17:15
 * @Version 1.0
 */

@Service
public class UserMemberServiceImpl implements UserMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;


    @Override
    public UmsMember login(UmsMember umsMember) {
        UmsMemberExample example=new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(umsMember.getPhone()).andPasswordEqualTo(umsMember.getPassword());
        List<UmsMember> list=umsMemberMapper.selectByExample(example);
        if(list.isEmpty()){
            return null;
        }
        umsMember=list.get(0);
        return umsMember;
    }

    @Override
    public UmsMember register(UmsMember umsMember) {
        umsMember.setCreateTime(new Date());
        int b=umsMemberMapper.insertSelective(umsMember);
        if(b>0){
            return umsMember;
        }
        return null;
    }
}
