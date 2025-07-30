import java.io.*;
import java.util.*;

class DataStructures_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        // 스택 사용 예시
        stackExample();
        
        // 큐 사용 예시
        queueExample();
        
        // 우선순위 큐 사용 예시
        priorityQueueExample();
        
        // 트리셋 사용 예시
        treeSetExample();
        
        // 해시맵 사용 예시
        hashMapExample();
    }
    
    // 스택 (괄호 검사, 후위 표기법 등)
    // Time Complexity: O(1) for push/pop operations
    static void stackExample() {
        Stack<Integer> stack = new Stack<>();
        String expression = "()[]{}";
        
        System.out.println("괄호 검사: " + isValidParentheses(expression));
    }
    
    // Time Complexity: O(n) where n is the length of string
    // Space Complexity: O(n) for the stack in worst case
    static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);                  // O(1)
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();         // O(1)
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // 큐 (BFS, 시뮬레이션 등)
    // Time Complexity: O(1) for offer/poll operations
    // Space Complexity: O(n) where n is the number of elements
    static void queueExample() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);     // O(1)
        queue.offer(2);     // O(1)
        queue.offer(3);     // O(1)
        
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");  // O(1)
        }
        System.out.println();
    }
    
    // 우선순위 큐 (다익스트라, 최소/최대값 찾기)
    // Time Complexity: O(log n) for offer/poll operations
    // Space Complexity: O(n) where n is the number of elements
    static void priorityQueueExample() {
        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int num : arr) {
            minHeap.offer(num);     // O(log n)
            maxHeap.offer(num);     // O(log n)
        }
        
        System.out.print("최소 힙: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");    // O(log n)
        }
        System.out.println();
        
        System.out.print("최대 힙: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");    // O(log n)
        }
        System.out.println();
    }
    
    // TreeSet (정렬된 집합, 범위 검색)
    // Time Complexity: O(log n) for add/remove/search operations
    // Space Complexity: O(n) where n is the number of elements
    static void treeSetExample() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);     // O(log n)
        treeSet.add(2);     // O(log n)
        treeSet.add(8);     // O(log n)
        treeSet.add(1);     // O(log n)
        
        System.out.println("TreeSet: " + treeSet);
        System.out.println("첫 번째: " + treeSet.first());              // O(log n)
        System.out.println("마지막: " + treeSet.last());                // O(log n)
        System.out.println("5보다 작은 가장 큰 값: " + treeSet.lower(5));    // O(log n)
        System.out.println("5보다 큰 가장 작은 값: " + treeSet.higher(5));   // O(log n)
    }
    
    // HashMap (빈도 카운팅, 해시 테이블)
    // Time Complexity: O(1) average for put/get operations, O(n) worst case
    // Space Complexity: O(n) where n is the number of key-value pairs
    static void hashMapExample() {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        
        // 빈도 카운팅 - Overall: O(n)
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);   // O(1) average
        }
        
        System.out.println("단어 빈도: " + map);
        
        // 최대 빈도 찾기 - O(n) where n is the number of unique words
        String maxWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        
        System.out.println("가장 많이 나온 단어: " + maxWord + " (" + maxCount + "번)");
    }
}