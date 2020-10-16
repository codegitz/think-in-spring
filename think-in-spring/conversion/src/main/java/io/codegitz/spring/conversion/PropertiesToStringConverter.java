package io.codegitz.spring.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * {@link Properties } -> {@link String } {@link ConditionalGenericConverter} 实现
 *
 * @author 张观权
 * @date 2020/10/15 20:58
 * @see ConditionalGenericConverter
 * @since
 **/
public class PropertiesToStringConverter implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return Properties.class.equals(sourceType.getObjectType()) && String.class.equals(targetType.getObjectType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Properties.class,String.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Properties properties = (Properties) source;

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Object, Object> entry : properties.entrySet()){
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
}
