package com.exercises;

// There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
// Given two strings, write a function to check if they are one edit (or zero edits away)
public class Exercise1dot5 {

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "bale";

        System.out.println(isOneWay(s1, s2));
    }

    private static boolean isOneWay(String s1, String s2) {
        if(s1.length() == s2.length()){
            return isOneReplace(s1, s2);
        }else if (s1.length() + 1 == s2.length()){
            return isOneInsert(s1, s2);
        }else if (s1.length() - 1 == s2.length()){
            return isOneInsert(s2, s1);
        }

        return false;
    }

    private static boolean isOneInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean isOneReplace(String s1, String s2) {
        boolean foundDifference = false;

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                if (foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

}
