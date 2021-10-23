package io.codegitz.spring.common.mistakes.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 张观权
 * @date 2021/8/26 12:27
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 **/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, nums.length, result, new ArrayList<Integer>(), used);
        return result;
    }

    private void dfs(int[] nums, int deep, int targetDeep, List<List<Integer>> result, ArrayList<Integer> tmp, boolean[] used) {
        if (deep == targetDeep) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            dfs(nums, deep + 1, targetDeep, result, tmp, used);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], -1);
        }
        path[m - 1][n - 1] = grid[m - 1][n - 1];
        return getPath(grid, path, 0, 0, m, n);
    }

    private static int getPath(int[][] grid, int[][] path, int i, int j, int m, int n) {
        if (path[i][j] != Integer.MAX_VALUE) {
            return path[i][j];
        }
        int rightCount = Integer.MAX_VALUE;
        int downCount = Integer.MAX_VALUE;
        if (i < m - 1) {
            rightCount = getPath(grid, path, i + 1, j, m, n);
        }
        if (j < n - 1) {
            downCount = getPath(grid, path, i, j + 1, m, n);
        }
        path[i][j] = grid[i][j] + Math.min(rightCount, downCount);
        return path[i][j];
    }

    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }
        int carry = 0;
        boolean first = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = first ? digits[i] + 1 + carry : digits[i] + carry;
            first = false;
            if (tmp == 10) {
                carry = 1;
                digits[i] = 0;
            } else {
                carry = 0;
                digits[i] = tmp;
            }

        }
        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }

    public static String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        if (bChar.length > aChar.length) {
            char[] tmp = aChar;
            aChar = bChar;
            bChar = tmp;
        }
        int carry = 0;
        int i = aChar.length - 1;
        int j = bChar.length - 1;
        int pos = aChar.length - 1;
        while (i >= 0 && j >= 0) {
            int add = aChar[i] - '0' + bChar[j] - '0' + carry;
            if (add > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            aChar[i] = String.valueOf(add % 2).toCharArray()[0];
            i--;
            j--;
            pos--;
        }
        if (carry > 0) {
            if (pos == aChar.length - 1) {
                return new StringBuilder().append(1).append(aChar).toString();
            } else {
                while (carry > 0 && pos >= 0) {
                    int add = aChar[pos] - '0' + carry;
                    if (add > 1) {
                        carry = 1;
                        aChar[pos] = String.valueOf(add % 2).toCharArray()[0];
                        pos--;
                    } else {
                        carry = 0;
                        aChar[pos] = (char) add;
                        pos--;
                    }

                }
            }
        }
        if (carry > 0) {
            return new StringBuilder().append(1).append(aChar).toString();
        }
        return new StringBuilder().append(aChar).toString();
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        Integer min = 0;

        return min;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        getCombine(0, result, new ArrayList<Integer>(), nums, k, new HashSet<Integer>());
        return result;
    }

    private void getCombine(int index, List<List<Integer>> result, ArrayList<Integer> tmp, List<Integer> nums, int k, HashSet<Integer> set) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (set.contains(nums.get(i))) {
                continue;
            }
            tmp.add(nums.get(i));
            set.add(nums.get(i));
            getCombine(i + 1, result, tmp, nums, k, set);
            set.remove(nums.get(i));
            tmp.remove(tmp.size() - 1);
        }
    }

    /**
     * excellent solution
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(1, n, k, list, res);
        return res;
    }

    private void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n - i + 1 >= k - list.size()) {
                list.add(i);
                int size = list.size();
                helper(i + 1, n, k, list, res);
                list.remove(size - 1);
            }
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i <= nums.length; i++) {
            getCombine(0, result, new ArrayList<>(), nums, i, new HashSet<Integer>());
        }
        return result;
    }

    private void getCombine(int index, List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, int k, HashSet<Integer> set) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            set.add(nums[i]);
            getCombine(i + 1, result, tmp, nums, k, set);
            set.remove(nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int tmp = nums[0];
        int count = 1;
        int remove = 0;
//         [1,1,1,2,2,3]
//        [1,1,2,2,3,3]
        for (int i = 1; i < nums.length - remove; i++) {
            if (nums[i] == tmp && count < 2) {
                count++;
                continue;
            }
            if (nums[i] == tmp && count == 2) {
                int j = i;
                remove++;
                while (j < nums.length) {
                    nums[j] = nums[j + 1];
                    j++;
                }
                i--;
            } else {
                tmp = nums[i];
                count = 1;
            }
        }
        return nums.length - remove;

    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;

        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        //[2,1,5,6,2,3]
        for (int i = 1; i < newHeights.length; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int mid = i - stack.peekLast() - 1;
                max = Math.max(max, height * mid);
            }
            stack.addLast(i);
        }
        return max;
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        boolean[] used = new boolean[1 << n];
        used[0] = true;
        backtrack(n, curr, used);
        return curr;
    }

    private static boolean backtrack(int n, List<Integer> curr, boolean[] used) {
        if (curr.size() == 1 << n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            int nex = (1 << i) ^ curr.get(curr.size() - 1); // (1 << i) is the mask in example, nex is next valid number
            if (used[nex]) continue;
            used[nex] = true;
            curr.add(nex);
            if (backtrack(n, curr, used)) return true;
            used[nex] = false;
            curr.remove(curr.size() - 1);
        }
        return false;
    }

//    public static void main(String[] args) {
//        List<String> ips = restoreIpAddresses("1111");
//        System.out.println(ips);
//    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        restore(result, 0, new ArrayList<String>(), s);
        return result;
    }

    private static void restore(List<String> result, int dot, ArrayList<String> tmp, String s) {
        if (dot == 3 && s.length() <= 3 && Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255) {
            if (s.charAt(0) - '0' == 0 && s.length() > 1) {
                return;
            }
            tmp.add(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                sb.append(tmp.get(i));
                if (i != tmp.size() - 1) {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
            tmp.remove(tmp.size() - 1);
            return;
        }
        for (int i = 0; i < 3 && i + 1 < s.length(); i++) {
            String ip = s.substring(0, i + 1);
            if (ip.charAt(0) - '0' == 0 && ip.length() > 1) {
                continue;
            }
            Integer integer = Integer.valueOf(ip);
            if (integer >= 0 && integer <= 255) {
                tmp.add(ip);
                restore(result, dot + 1, tmp, s.substring(i + 1));
                tmp.remove(tmp.size() - 1);
            }

        }
    }

//    public static void main(String[] args) {
//        List<TreeNode> treeNodes = generateTrees(3);
//        System.out.println(treeNodes);
//    }
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        for (int i = 0; i < n; i++) {
            Integer remove = nums.remove(i);
            TreeNode root = new TreeNode(remove);
            generate(result,nums,nums.size(), root, root);
            nums.add(i,remove);
        }
        return result;

    }

    private static void generate(List<TreeNode> result, List<Integer> nums,int n, TreeNode root,TreeNode tmp) {
        if (nums.size() == 0){
            result.add(copy(new TreeNode(),root));
            return;
        }
        for (int i = 0; i < n; i++) {
            Integer remove = nums.remove(i);
            if (remove > tmp.val){
                TreeNode treeNode = new TreeNode(remove);
                tmp.right = treeNode;
                generate(result,nums,nums.size(),root,treeNode);
                tmp.right = null;
            }
            if (remove < tmp.val){
                TreeNode treeNode = new TreeNode(remove);
                tmp.left = treeNode;
                generate(result,nums,nums.size(),root,treeNode);
                tmp.left = null;
            }
            nums.add(i,remove);
        }
    }

    private static TreeNode copy(TreeNode copy,TreeNode root) {
        copy.val = root.val;
        if (root.left != null){
            TreeNode left = new TreeNode();
            copy.left= left;
            copy(left,root.left);
        }
        if (root.right != null){
            TreeNode right = new TreeNode();
            copy.right = right;
            copy(right,root.right);
        }
        return copy;
    }

    public List<TreeNode> generateTree(int start, int end){
        List<TreeNode> res = new ArrayList<>();

        if(start > end){
            res.add(null);
            return res;
        }

        for(int i=start; i<=end; i++){
            for(TreeNode left: generateTree(start, i-1)){
                for(TreeNode right: generateTree(i+1, end)){
                    TreeNode Tree = new TreeNode(i);

                    Tree.left = left;
                    Tree.right = right;
                    res.add(Tree);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees2(int n) {
        if(n == 0)
            return generateTree(1, 0);

        return generateTree(1, n);
    }

//    public static void main(String[] args) {
//        // [1,2,2,3,3,null,null,4,4]
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node22 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node33 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node44 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node22;
//        node2.left = node3;
//        node2.right = node33;
//        node3.left = node4;
//        node3.right = node44;
//        boolean balanced = isBalanced(node1);
//        System.out.println(balanced);
//    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        AtomicBoolean flag = new AtomicBoolean(true);
        balance(root,flag);
        return flag.get();
    }
    public static void balance(TreeNode root, AtomicBoolean flag){
        if(!flag.get()){
            return;
        }
        if(root == null){
            return;
        }
        flag.set(Math.abs(deep(root.left) - deep(root.right)) < 2);
        if(!flag.get()){
            return;
        }
        balance(root.left,flag);
        balance(root.right,flag);
        return;
    }
    public static int deep(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(deep(root.left),deep(root.right)) + 1;
    }

//    public static void main(String[] args) {
//        // [1,2,2,3,3,null,null,4,4]
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node22 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node33 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node44 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        int i = sumNumbers(node1);
//        System.out.println(i);
//    }
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,root,new ArrayList<Integer>());
        int sum = 0;
        for (List<Integer> list : result) {
            int coefficient = 1;
            for (int i = list.size() - 1; i >= 0; i--) {
                sum += list.get(i) * coefficient;
                coefficient *= 10;
            }
        }
        return sum;
    }
    public static void dfs(List<List<Integer>> result,TreeNode root,List<Integer> tmp){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            tmp.add(root.val);
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        if (root.left != null){
            tmp.add(root.val);
            dfs(result,root.left,tmp);
            tmp.remove(tmp.size() - 1);
        }
        if (root.right != null){
            tmp.add(root.val);
            dfs(result,root.right,tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int canCompleteCircuit = canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
        System.out.println(canCompleteCircuit);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null){
            return -1;
        }
        int sum = 0;
        for(int i = 0 ; i < gas.length; i++){
            sum++;
            int tank = 0;
            if(gas[i] < cost[i]){
                continue;
            }
            tank = gas[i] - cost[i];
            int tmp = 1;
            while(tank >= 0){
                tank = tank - cost[(i + 1)% gas.length] + gas[(i + 1)% gas.length];
                i = (i + 1) % (gas.length);
                tmp++;
                if(tmp == gas.length){
                    break;
                }
            }
            if(tank >= 0){
                return (i + 1) % (gas.length);
            }else if (sum == gas.length ){
                return -1;
            }
        }
        return -1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
