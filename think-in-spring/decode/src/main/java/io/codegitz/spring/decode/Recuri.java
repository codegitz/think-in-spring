package io.codegitz.spring.decode;

import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2020/12/10 17:43
 **/
public class Recuri {
    public static void main(String[] args) {
        List<Tmp> list = new ArrayList<>();
        List<Tmp> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Tmp tmp = new Tmp();
            tmp.setSort(i);
            list.add(tmp);
        }
        for (int i = 9; i >= 0; i--){
            Tmp tmp = new Tmp();
            tmp.setId("String.valueOf(i)");
            tmp.setSort(i);
            list1.add(tmp);
        }

        BigDecimal interest =new BigDecimal(1.22);
        BigDecimal a =new BigDecimal("1.22");
        // list1 - > list
        List<Tmp> tmpList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Map<Integer, Tmp> collect1 = list1.stream().collect(Collectors.toMap(Tmp::getSort, t -> t));
        list.stream().forEach(tmp -> {
            Tmp tmp1 = collect1.get(tmp.getSort());
            tmpList.add(tmp1);
        });
        list.forEach(tmp -> {
            System.out.print(tmp.getSort()+" ");
        });
        System.out.println();
        list1.forEach(tmp -> {
            System.out.print(tmp.getSort()+" ");
        });
        System.out.println();
        tmpList.forEach(tmp -> {
            System.out.print(tmp.getSort()+" ");
        });

        stopWatch.stop();
        System.out.println();
        System.out.println(stopWatch.prettyPrint());

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
