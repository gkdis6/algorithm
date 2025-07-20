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
    static void stackExample() {
        Stack<Integer> stack = new Stack<>();
        String expression = "()[]{}";
        
        System.out.println("괄호 검사: " + isValidParentheses(expression));
    }
    
    static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
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
    static void queueExample() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
    
    // 우선순위 큐 (다익스트라, 최소/최대값 찾기)
    static void priorityQueueExample() {
        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int num : arr) {
            minHeap.offer(num);
            maxHeap.offer(num);
        }
        
        System.out.print("최소 힙: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
        
        System.out.print("최대 힙: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }
    
    // TreeSet (정렬된 집합, 범위 검색)
    static void treeSetExample() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        
        System.out.println("TreeSet: " + treeSet);
        System.out.println("첫 번째: " + treeSet.first());
        System.out.println("마지막: " + treeSet.last());
        System.out.println("5보다 작은 가장 큰 값: " + treeSet.lower(5));
        System.out.println("5보다 큰 가장 작은 값: " + treeSet.higher(5));
    }
    
    // HashMap (빈도 카운팅, 해시 테이블)
    static void hashMapExample() {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        
        // 빈도 카운팅
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("단어 빈도: " + map);
        
        // 최대 빈도 찾기
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