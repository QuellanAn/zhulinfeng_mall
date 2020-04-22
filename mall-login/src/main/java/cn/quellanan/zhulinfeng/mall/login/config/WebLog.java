package cn.quellanan.zhulinfeng.mall.login.config;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class WebLog {

    private String description;

    private String username;

    private Long startTime;

    private String spendTime;

    private String basePath;
    private String url;

    private String method;

    private String ip;

    private Object parameter;

    private Object result;


}
