package io.codegitz.spring.conversion;

import java.beans.PropertyEditor;

/**
 * {@link java.beans.PropertyEditor} 示例
 * @author 张观权
 * @date 2020/10/13 13:19
 * @see java.beans.PropertyEditor
 * @since
 **/
public class PropertyEditorDemo {
    public static void main(String[] args) {

        // 模拟 Spring Framework的操作
        // 有一段文本 name = Codegitz
        String text = "name = Codegitz";

        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();

        // 传递 String 类型内容
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());

        System.out.println(propertyEditor.getAsText());
    }
}
