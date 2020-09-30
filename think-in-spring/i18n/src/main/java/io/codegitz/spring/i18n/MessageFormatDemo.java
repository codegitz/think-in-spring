package io.codegitz.spring.i18n;

import sun.security.rsa.RSASignature;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * {@link java.text.MessageFormat} 实现示例
 *
 * @author 张观权
 * @date 2020/9/30 16:42
 **/
public class MessageFormatDemo {
    public static void main(String[] args) {

        int planet = 7;
        String event = "a disturbance in the Force";

        String messageFormatPattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        MessageFormat messageFormat = new MessageFormat(messageFormatPattern);
        String result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);

        // 重置MessageFormatPattern
        // applyPattern
        messageFormatPattern = "This is a text :{0},{1} ";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[]{"hello world."});
        System.out.println(result);

        // 重置locale
        messageFormat.setLocale(Locale.ENGLISH);
        messageFormatPattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        messageFormat.applyPattern(messageFormatPattern);
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);

        // 重置Format
        // 根据参数索引来设置Pattern
        messageFormat.setFormat(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);

        /**
         * 依次输出
         * At 下午04时59分40秒 on 2020年9月30日 星期三, there was a disturbance in the Force on planet 7.
         * This is a text :hello world.,{1}
         * At 4:59:40 PM CST on Wednesday, September 30, 2020, there was a disturbance in the Force on planet 7.
         * At 4:59:40 PM CST on 2020-09-30 16:59:40, there was a disturbance in the Force on planet 7.
         */
    }
}
