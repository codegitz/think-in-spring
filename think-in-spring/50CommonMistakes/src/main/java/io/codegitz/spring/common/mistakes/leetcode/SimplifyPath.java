package io.codegitz.spring.common.mistakes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2021/9/14 17:25
 *
 * 71. Simplify Path
 * Medium
 *
 * 749
 *
 * 198
 *
 * Add to List
 *
 * Share
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 *
 * Input: path = "/a/./b/../../c/"
 * Output: "/c"
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 *
 **/
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/b/DfZ/AT/ya///./../../";
        String split = simplifyPath(path);
        System.out.println(split);
    }
    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0){
            return path;
        }
        String[] split = path.split("/");
        StringBuilder sb = new StringBuilder();
        List<String> re = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("") || split[i].equals(".")){
                continue;
            }
            if (!split[i].equals("..") && i + 1 < split.length && split[i + 1].equals("..")){
                i++;
                continue;
            }
            if (split[i].equals("..") && re.size() - 1 >= 0){
                re.remove(re.size() - 1);
                continue;
            }else if (split[i].equals("..") && re.size() == 0){
                continue;
            }
            re.add(split[i]);
        }
        if (re.isEmpty()){
            return "/";
        }
        sb.append("/");
        for (int i = 0; i < re.size(); i++) {
            sb.append(re.get(i));
            if (i == re.size() - 1){
                break;
            }
            sb.append("/");
        }
        return sb.toString();
    }
}
