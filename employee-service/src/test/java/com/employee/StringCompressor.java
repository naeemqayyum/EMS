package com.employee;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class StringCompressor {


    public static String compress(String input) {
        if (input == null || input.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        // Start from the second character
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(currentChar).append(count);
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        // Append the last group
        result.append(currentChar).append(count);

        return result.toString();
    }


    public static void main(String[] args) {
//        String input = "aaabbccccdaa";
//        String output = compress(input);
//
//
//        System.out.println(output);  // Output: a3b2c4d1a2

        //Input: "{[()]}"
        //Output: true
        //
        //Input: "{[(])}"
        //Output: false

//        System.out.println("validate brackets " + validateBrackets("{[()]}"));
//        System.out.println("validate brackets " + validateBrackets("{[(])}"));

//        Input:
//        "aabccbd"
//        Output:
//        "d"

//bbbbb
        // System.out.println("character is  : " + findFirstNonRepeatingChar("aabccbd"));
        // System.out.println("longest non repeated subStr " + longestSubStrwithoutRepeatingChar("abcabcbb"));
        //System.out.println("longest non repeated subStr " + longestSubStrwithoutRepeatingChar("bbbbb"));
        System.out.println("longest non repeated subStr " + longestSubStrwithoutRepeatingChar("pwwkew"));
        //System.out.println("longest non repeated subStr " + longestSubStrwithoutRepeatingChar("abcabcbb"));


        //. Maximum Sum Subarray of Size K
        //Given an array of integers and a number k, find the maximum sum of a subarray of size k.
        //
        //Input: [2, 1, 5, 1, 3, 2], k = 3
        //Output: 9
        //(Because 5 + 1 + 3 = 9)

        int sum = findMaxiumSumofsubArray(new int[]{2, 1, 5, 1, 3, 2}, 3);
        System.out.println("sum is : " + sum);

        //2. Longest Substring Without Repeating Characters
        //Given a string, find the length of the longest substring without repeating characters.
        //
        //Input: "abcabcbb"
        //Output: 3

        Burger burger = new Burger.Builder()
                .lettuce(true)
                .bun("")
                .build();
    }

    private static int findMaxiumSumofsubArray(int[] arr, int k) {
        int sum = 0;
        int highestSum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        highestSum = sum;
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            if (sum > highestSum) {
                highestSum = sum;
            }
        }

        return highestSum;
    }

    private static String longestSubStrwithoutRepeatingChar(String element) {
        String longestStr = "";
        if (element == null || element.length() == 0)
            return longestStr;
        longestStr = "";
        String str = "";
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < element.length(); i++) {
            if (!seen.contains(element.charAt(i))) {
                seen.add(element.charAt(i));
                str += String.valueOf(element.charAt(i));
            } else {
                if (str.length() >= longestStr.length()) {
                    longestStr = str;
                    str = "";
                    seen.clear();
                }
            }
        }


        return longestStr;
    }

    private static Character findFirstNonRepeatingChar(String element) {
        Character character = null;
        if (element == null || element.length() == 0) {
            return character;
        }

        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < element.length(); i++) {
            linkedHashMap.put(element.charAt(i), linkedHashMap.getOrDefault(element.charAt(i), 0) + 1);

        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : linkedHashMap.entrySet()) {
            if (characterIntegerEntry.getValue() == 1) {
                character = characterIntegerEntry.getKey();
            }

        }

        return character;
    }

    private static boolean validateBrackets(String element) {
        boolean isValidString = true;
        if (element == null || element.length() == 0) {
            return isValidString;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < element.length(); i++) {
            Character charAt = element.charAt(i);
            if (charAt == '{' || charAt == '(' || charAt == '[') {
                stack.push(charAt);
            } else if (charAt == '}' || charAt == ')' || charAt == ']') {
                if (stack.peek() == charAt)
                    stack.pop();
            }


        }

        if (stack.size() > 0) {
            isValidString = false;

        }
        return isValidString;
    }


}
