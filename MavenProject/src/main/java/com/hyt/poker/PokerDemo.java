package com.hyt.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hou
 * @create 2019-08-17 18:03
 **/
public class PokerDemo {

    public static void main(String[] args) {
        List<String> pokerList = initPoker();
        Map<String, List<String>> playerMap = initPlayer(pokerList);
        System.out.println(playerMap);
    }

    private static Map<String, List<String>> initPlayer(List<String> pokerList) {
        Map<String, List<String>> playerMap = new LinkedHashMap<String, List<String>>();
        List<String> player1 = new ArrayList<String>();
        List<String> player2 = new ArrayList<String>();
        List<String> player3 = new ArrayList<String>();
        List<String> deskPoker = new ArrayList<String>();

        int pokerSize = pokerList.size();
        for (int pokerIndex = 0; pokerIndex < pokerSize; pokerIndex++) {
            String poker = pokerList.get(pokerIndex);
            if (pokerIndex <= 2) {
                deskPoker.add(poker);
            } else {
                if (pokerIndex % 3 == 0) {
                    player1.add(poker);
                } else if (pokerIndex % 3 == 1) {
                    player2.add(poker);
                } else {
                    player3.add(poker);
                }
            }
        }
        Comparator<String> comparator = getStringComparator();

        Collections.sort(player1, comparator);
        Collections.sort(player2, comparator);
        Collections.sort(player3, comparator);
        Collections.sort(deskPoker, comparator);

        playerMap.put("player1", player1);
        playerMap.put("player2", player2);
        playerMap.put("player3", player3);
        playerMap.put("deskPoker", deskPoker);
        return playerMap;
    }

    private static Comparator<String> getStringComparator() {
        return new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // 降序排列
                    if (s1.equals("King")) {
                        return -1;
                    } else if (s2.equals("King")) {
                        return 1;
                    }
                    if (s1.equals("smartKing")) {
                        return -1;
                    } else if (s2.equals("smartKing")) {
                        return 1;
                    }
                    return comparePoker(s1, s2);
                }
            };
    }

    private static int comparePoker(String s1, String s2) {
        int flower1 = getFlowerRank(s1);
        int num1 = getNumRank(s1);
        int flower2 = getFlowerRank(s2);
        int num2 = getNumRank(s2);
        //降序效果，2-1
        if (num1 != num2) {
            return num2 - num1;
        } else {
            return flower2 - flower1;
        }
    }

    private static int getNumRank(String str) {
        int rank;
        String num = str.substring(1);
        switch (num) {
            case "3":
                rank = 1;
                break;
            case "4":
                rank = 2;
                break;
            case "5":
                rank = 3;
                break;
            case "6":
                rank = 4;
                break;
            case "7":
                rank = 5;
                break;
            case "8":
                rank = 6;
                break;
            case "9":
                rank = 7;
                break;
            case "10":
                rank = 8;
                break;
            case "J":
                rank = 9;
                break;
            case "Q":
                rank = 10;
                break;
            case "K":
                rank = 11;
                break;
            case "A":
                rank = 12;
                break;
            default:
                rank = 13;
                break;
        }
        return rank;
    }

    private static int getFlowerRank(String str) {
        int rank;
        char flower = str.charAt(0);
        switch (flower) {
            case '♠':
                rank = 3;
                break;
            case '♥':
                rank = 2;
                break;
            case '♣':
                rank = 1;
                break;
            default:
                rank = 0;
                break;
        }
        return rank;
    }

    private static List<String> initPoker() {
        List<String> list1 = Arrays.asList("♠", "♣", "♥", "♦");
        List<String> list2 = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        List<String> pokerList = new ArrayList<>();
        pokerList.add("King");
        pokerList.add("smartKing");
        for (String s1 : list1) {
            for (String s2 : list2) {
                pokerList.add(s1 + s2);
            }
        }
        Collections.shuffle(pokerList);
        return pokerList;
    }
}
