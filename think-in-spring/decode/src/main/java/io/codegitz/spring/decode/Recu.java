package io.codegitz.spring.decode;

import io.codegitz.spring.decode.dto.InfoDTO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2020/12/10 17:43
 **/
public class Recu {
    public static void main(String[] args) {
        List<Tmp> list = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Tmp tmp = new Tmp();
            tmp.setId(String.valueOf(i));
            tmp.setMtime(System.currentTimeMillis());
            list.add(tmp);
            stringList.add(String.valueOf(i));
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++){
            Tmp tmp = new Tmp();
            tmp.setId(String.valueOf(i));
            tmp.setMtime(System.currentTimeMillis());
            list.add(tmp);
            stringList.add(String.valueOf(i));
        }

//        List<Tmp> collect = list.stream().distinct().collect(Collectors.toList());
//
//        List<String> collect1 = stringList.stream().distinct().collect(Collectors.toList());
//        collect1.stream().forEach(s -> {
//            System.out.println(s);
//        });

        list.forEach(tmp -> {
            System.out.println(tmp.getId()+" : "+tmp.getMtime());
        });

        System.out.println("===================");
        List<Tmp> collect = new ArrayList<>(list.stream().collect(Collectors.toMap(Tmp::getId, a -> a, (k1, k2) -> k2)).values());
        collect.stream().forEach(tmp -> {
            System.out.println(tmp.getId()+" : "+tmp.getMtime());
        });
    }


    static class Tmp {
        private String id;
        private Date time;
        private long mtime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public long getMtime() {
            return mtime;
        }

        public void setMtime(long mtime) {
            this.mtime = mtime;
        }
    }
}
