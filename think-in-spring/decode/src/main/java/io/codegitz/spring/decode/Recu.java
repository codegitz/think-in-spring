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
        Tmp tmdp = new Tmp();
        tmdp.setId("ddd");
        if (tmdp.getId().equals(tmdp.getId())){
            System.out.println("hh");
        }
        List<Tmp> list = new ArrayList<>();
        List<Tmp> list1 = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Tmp tmp = new Tmp();
            tmp.setId(String.valueOf(i));
            tmp.setMtime(System.currentTimeMillis());
            tmp.setSort(i);
            list.add(tmp);
            stringList.add(String.valueOf(i));
        }
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 10; i > 1; i--){
            Tmp tmp = new Tmp();
            tmp.setId("String.valueOf(i)");
            tmp.setMtime(System.currentTimeMillis());
            tmp.setSort(i);
            list1.add(tmp);
            stringList.add(String.valueOf(i));
        }

        // list1 - > list
        List<Tmp> tmpList = new ArrayList<>();
        Map<Integer, Tmp> collect1 = list1.stream().collect(Collectors.toMap(Tmp::getSort, t -> t));
        list.stream().forEach(tmp -> {
            Tmp tmp1 = collect1.get(tmp.getSort());
            tmpList.add(tmp1);
        });
        list.forEach(tmp -> {
            System.out.println(tmp.getSort());
        });
//        tmpList.forEach(tmp -> {
//            System.out.println(tmp.getSort());
//        });


//        List<Tmp> collect = list.stream().distinct().collect(Collectors.toList());
//
//        List<String> collect1 = stringList.stream().distinct().collect(Collectors.toList());
//        collect1.stream().forEach(s -> {
//            System.out.println(s);
//        });

//        list.forEach(tmp -> {
//            System.out.println(tmp.getId()+" : "+tmp.getMtime());
//        });
//
//        System.out.println("===================");
//        List<Tmp> collect = new ArrayList<>(list.stream().collect(Collectors.toMap(Tmp::getId, a -> a, (k1, k2) -> k2)).values());
//        collect.stream().forEach(tmp -> {
//            System.out.println(tmp.getId()+" : "+tmp.getMtime());
//        });

//        Tmp t = new Tmp();
//        for (Tmp tmp : collect){
//            if (tmp.getId().equals("5")){
//                break;
//            }
//            t=tmp;
//        }
    }


    static class Tmp {
        private String id;
        private Date time;
        private long mtime;
        private int sort;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

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
