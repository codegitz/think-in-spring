package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath2 {
    public static void main(String[] args) {

    }

    class Solution {
        public String simplifyPath(String path) {
            String[] arrPath = path.split("/");
            StringBuilder sb = new StringBuilder("/");
            List<String> l = new ArrayList<>();
            for(int i = 0;i < arrPath.length;i++) {
                if("".equals(arrPath[i]) || ".".equals(arrPath[i])) {
                    continue;
                }

                if("..".equals(arrPath[i])) {
                    if(l.size() == 0) {
                        continue;
                    }
                    l.remove(l.size() - 1);
                    continue;
                }

                l.add(arrPath[i]);
            }

            l.forEach(str -> sb.append(str + "/"));
            if(sb.length() > 1) {
                return sb.substring(0, sb.length() - 1);
            }
            return sb.toString();
        }
    }
}
