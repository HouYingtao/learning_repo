package com.hyt.recursion;

import java.io.File;

/**
 * 遍历某个文件夹下的所有文件，分级
 *
 * @author hou
 * @create 2019-08-24 22:34
 **/
public class RecursionDemo {

    public static void main(String[] args) {
        String path = "F:\\1.基础班\\就业班资料\\day08\\code\\08_FileAndRecursion";
        showDirectoryItem(path);
    }

    private static void showDirectoryItem(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            System.out.println("无效的文件夹路径。");
            return;
        }
        int hierarchy = 0;
        loopDierctory(file, hierarchy);
    }

    private static void loopDierctory(File dierctoryName, int hierarchy) {
        // getTabStr(hierarchy) 和 dierctoryName.getName()不能合并，不知道为啥
        System.out.print(getTabStr(hierarchy));
        System.out.println(dierctoryName.getName());
        hierarchy++;
        File[] files = dierctoryName.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                // 打印文件名称
                System.out.print(getTabStr(hierarchy));
                System.out.println(file.getName());
            } else {
                // 递归打印文件夹
                loopDierctory(file, hierarchy);
            }
        }
    }

    private static String getTabStr(int hierarchy) {
        StringBuilder sbStr = new StringBuilder();
        for (int i = 0; i < hierarchy; i++) {
            sbStr.append("\t");
        }
        return sbStr.toString();
    }
}
