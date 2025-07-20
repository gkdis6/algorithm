import java.io.*;
import java.util.*;

class String_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        String text = "abcabcabc";
        String pattern = "abc";
        
        // KMP 알고리즘
        System.out.println("KMP 매칭 결과: " + kmpSearch(text, pattern));
        
        // 문자열 뒤집기
        System.out.println("뒤집기: " + reverseString(text));
        
        // 회문 검사
        System.out.println("회문 검사: " + isPalindrome("racecar"));
        
        // 아나그램 검사
        System.out.println("아나그램 검사: " + isAnagram("listen", "silent"));
        
        // 문자열 압축
        System.out.println("문자열 압축: " + compressString("aaabbbccc"));
    }
    
    // KMP 알고리즘 - 문자열 검색
    static ArrayList<Integer> kmpSearch(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] lps = computeLPS(pattern);
        
        int i = 0; // text의 인덱스
        int j = 0; // pattern의 인덱스
        
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == pattern.length()) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return result;
    }
    
    // LPS 배열 계산
    static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
    
    // 문자열 뒤집기
    static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    // 회문 검사
    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // 아나그램 검사
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] count = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // 문자열 압축
    static String compressString(String s) {
        if (s.length() == 0) return s;
        
        StringBuilder compressed = new StringBuilder();
        char current = s.charAt(0);
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            } else {
                compressed.append(current).append(count);
                current = s.charAt(i);
                count = 1;
            }
        }
        
        compressed.append(current).append(count);
        
        return compressed.length() < s.length() ? compressed.toString() : s;
    }
}