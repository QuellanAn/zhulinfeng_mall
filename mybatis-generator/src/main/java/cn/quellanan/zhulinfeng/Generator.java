package cn.quellanan.zhulinfeng;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Generator
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/21 15:07
 * @Version 1.0
 */
public class Generator {
    public static void main(String[] args)  throws Exception{

        List<String> warnings = new ArrayList<>();
        File configFile = new File("D:\\IDE\\zhulinfeng_mall\\mybatis-generator\\src\\main\\resources\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
