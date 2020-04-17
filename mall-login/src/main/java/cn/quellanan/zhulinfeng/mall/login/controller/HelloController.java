package cn.quellanan.zhulinfeng.mall.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/16 17:49
 * @Version 1.0
 */

@RestController
public class HelloController {


    @RequestMapping("/")
    public String hello(){
        return "hell welcome to mall";
    }
}
