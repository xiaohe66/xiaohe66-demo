package com.xiaohe66.demo.arithmetic.leetcode;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ClassPathUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author xiaohe
 * @time 2020.09.09 14:46
 */
public class LeetCodeUtils {

    private LeetCodeUtils() {

    }

    /**
     * 作者：Ghimtim
     * 链接：https://leetcode-cn.com/circle/article/htJ97s/
     * 来源：力扣（LeetCode）
     */
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static boolean equalsList(List<?> list1, List<?> list2) {

        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);

        if (list1 == list2) {
            return true;
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        Set<?> set1 = new HashSet<>(list1);
        if (set1.size() != list1.size()) {
            return false;
        }

        Set<?> set2 = new HashSet<>(list2);
        if (set2.size() != list2.size()) {
            return false;
        }

        return set1.equals(set2);
    }

    public static void outArr2(int[][] arr) {
        StringBuilder out = new StringBuilder();
        for (int[] nums : arr) {
            out.append(Arrays.toString(nums));
        }
        System.out.println(out);
    }

    public static int[][] stringToArr2(String str) {

        if ("[]".equals(str)) {
            return new int[0][0];
        }

        String[] arr = str.split("\\],\\[");

        String replace = arr[0].replace("[[", "");
        arr[0] = replace;

        replace = arr[arr.length - 1].replace("]]", "");
        arr[arr.length - 1] = replace;

        int[][] ret = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {

            String[] nums = arr[i].split(",");

            ret[i] = new int[nums.length];

            for (int j = 0; j < nums.length; j++) {
                ret[i][j] = Integer.parseInt(nums[j]);
            }
        }

        return ret;
    }

    public static List<List<String>> stringToList2(String str) {

        if ("[]".equals(str)) {
            return Collections.emptyList();
        }

        String[] arr = str.split("\\],\\[");

        String replace = arr[0].replace("[[", "");
        arr[0] = replace;

        replace = arr[arr.length - 1].replace("]]", "");
        arr[arr.length - 1] = replace;

        List<List<String>> ret = new ArrayList<>(arr.length);

        for (String s : arr) {

            String[] nums = s.split(",");

            List<String> list = new ArrayList<>(nums.length);
            for (String num : nums) {

                list.add(num.trim());

            }

            ret.add(list);

        }

        return ret;
    }

    public static String readClassPathFile(Class<?> cls, String name) throws IOException {

        Package aPackage = cls.getPackage();

        String fullPath = ClassPathUtils.toFullyQualifiedPath(aPackage, name);

        ClassLoader classLoader = cls.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream(fullPath);

        if (inputStream == null) {
            throw new IOException("文件不存在 : " + name);
        }

        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }
}
