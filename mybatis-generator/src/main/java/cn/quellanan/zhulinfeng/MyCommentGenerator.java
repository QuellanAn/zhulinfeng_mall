package cn.quellanan.zhulinfeng;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @ClassName MyCommentGenerator
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/21 15:44
 * @Version 1.0
 */
public class MyCommentGenerator extends DefaultCommentGenerator {

    // 定义一个是否使用修改后的模式的标识
    private boolean suppressAllComments= true;
    private Properties properties;

    public MyCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }






    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }else {
            // 获取列注释
            String remarks = introspectedColumn.getRemarks();
            field.addJavaDocLine("//" + introspectedColumn.getRemarks());
        }
    }

    // 设置实体类 getter注释
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
                method.addJavaDocLine("//获取:" + introspectedColumn.getRemarks());
            }
        }else {
            super.addGetterComment(method, introspectedTable, introspectedColumn);
        }
    }

    // 设置实体类 setter注释
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
                method.addJavaDocLine("//设置:" + introspectedColumn.getRemarks());
            }
        } else {
            super.addSetterComment(method, introspectedTable, introspectedColumn);
        }
    }

    // 去掉mapper原始注释
    @Override
    public void addGeneralMethodComment(Method method,IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }else {
            super.addGeneralMethodComment(method, introspectedTable);
        }
    }

    // 去掉mapping原始注释
    @Override
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        }else {
            super.addComment(xmlElement);
        }
    }

}
