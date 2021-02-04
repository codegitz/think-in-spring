package io.codegitz.spring.decode;

/**
 * @author 张观权
 * @date 2021/1/15 16:59
 **/
public class FinalKey {
    public static void main(String[] args) {
//        final StringBuilder sb = new StringBuilder("haha");
//        //同一对象的hashCode值相同
//        System.out.println("sb中的内容是："+sb);
//        System.out.println(sb+"的哈希编码是:"+sb.hashCode());
//        sb.append("我变了");
//        System.out.println("sb中的内容是："+sb);
//        System.out.println(sb+"的哈希编码是:"+sb.hashCode());

        String name = "风险管理_申请进件信息.vl..xml";
        String[] s = name.split("_");
        System.out.println(s[1]);
        String[] split = s[1].split("\\.");
        System.out.println();
        for (String ss :split){
            System.out.println(ss);
        }
    }
}
