package io.codegitz.spring.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * String -> Properties {@link java.beans.PropertyEditor}
 *
 * @author 张观权
 * @date 2020/10/13 13:22
 **/
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    // 1.实现 setAsText(String) 方法
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // 2.将String类型装换成Properties类型
        Properties properties = new Properties();

        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        // 3.临时存储Properties对象
        setValue(properties);

        // 4.next 获取临时 Properties 对象#getValue();
    }

    @Override
    public String getAsText() {
        Properties properties = (Properties) getValue();

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Object, Object> entry : properties.entrySet()){
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}
