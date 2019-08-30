package com.hyt.test;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hou
 * @create 2019-07-07 23:09
 **/
public class RegexTest {

    public static void main(String[] args) {
//        adaptIdeConsole();
//        adaptCmdConsole();
    }

    private static void adaptIdeConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your regex:");
            String regexStr = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexStr);

            System.out.println("Enter input String to search:");
            String str = scanner.nextLine();
            Matcher matcher = pattern.matcher(str);

            boolean flag = false;
            while (matcher.find()) {
                System.out.printf("Found the text \"%s\" starting at index %d and ending at index %d.%n", matcher.group(), matcher.start(), matcher.end() - 1);
                flag = true;
            }
            if (!flag) {
                System.out.println("No match found.%n");
            }
        }
    }

    /**
     * 使用此方法需要删除首行package
     */
    private static void adaptCmdConsole() {
        Console console = System.console();
        if (null == console) {
            System.err.println("No console");
            System.exit(1);
        }
        while (true) {
            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex:"));
            Matcher matcher = pattern.matcher(console.readLine("Enter input String to search:"));

            boolean flag = false;
            while (matcher.find()) {
                console.format("Found the text \"%s\" starting at index %d and ending at index %d.%n", matcher.group(), matcher.start(), matcher.end());
                flag = true;
            }
            if (!flag) {
                console.format("No match found.%n");
            }
        }
    }
}
