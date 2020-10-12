package io.codegitz.spring.data.binding;

import io.codegitz.spring.ioc.overview.domain.Company;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link org.springframework.validation.DataBinder} 示例
 *
 * @author 张观权
 * @date 2020/10/12 13:12
 * @see org.springframework.validation.DataBinder
 * @since
 **/
public class DataBinderDemo {
    public static void main(String[] args) {
        // 创建空白对象
        User user = new User();
        // 创建数据绑定对象
        DataBinder dataBinder = new DataBinder(user);

        // 创建 PropertyValues
        Map<String,Object> source = new HashMap<String, Object>();
        source.put("id",1);
        source.put("name","Codegitz");

        // 假如 PropertyValues 属性中存在类中不存在的属性值
        // DataBinder 特性一 ： 忽略未知属性
        source.put("NotExist","oom");

        // 假如 PropertyValues 存在一个嵌套属性，如 company.name
        // DataBinder 特性二 ：支持嵌套属性
//        source.put("company",new Company());
        source.put("company.name","Google");

        PropertyValues propertyValues = new MutablePropertyValues(source);


        //===========测试================
        // 1.设置 setIgnoreInvalidFields true(默认) -> false(会抛出异常)
//        dataBinder.setIgnoreUnknownFields(false);

        // 2.调整自动添加嵌套路径 true(默认) -> false
//        dataBinder.setAutoGrowNestedPaths(false);

        // 3.设置 setIgnoreInvalidFields false(默认) -> true (默认情况调整不变化，需要调整 AutoGrowNestedPaths 为false)
        dataBinder.setIgnoreInvalidFields(true);

        // 白名单 必须存在的属性
        dataBinder.setRequiredFields("id","name","beanName");
        // 绑定对象
        dataBinder.bind(propertyValues);
        System.out.println(user);

        // 获取绑定结果，(结果包含错误文案 code ，不会抛出异常)
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult);
    }
}
