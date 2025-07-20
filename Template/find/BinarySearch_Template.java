import java.io.*;
import java.util.*;

class BinarySearch_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        // 배열 크기 입력
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        // 배열 요소 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 정렬 (이분 탐색 전 필수)
        Arrays.sort(arr);
        
        // 찾을 값 입력
        int target = Integer.parseInt(br.readLine());
        
        // 기본 이분 탐색
        int index = binarySearch(arr, target);
        System.out.println("인덱스: " + index);
        
        // lower bound 예시
        int lowerBound = lowerBound(arr, target);
        System.out.println("Lower Bound: " + lowerBound);
        
        // upper bound 예시
        int upperBound = upperBound(arr, target);
        System.out.println("Upper Bound: " + upperBound);
        
        // 범위 내 개수 구하기
        int count = upperBound - lowerBound;
        System.out.println("개수: " + count);
        
        // 매개 변수 탐색 예시
        parametricSearchExample();
    }
    
    // 기본 이분 탐색 - 값이 있으면 인덱스, 없으면 -1 반환
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // 찾지 못함
    }
    
    // Lower Bound - target 이상인 첫 번째 원소의 인덱스
    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // Upper Bound - target 초과인 첫 번째 원소의 인덱스
    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    // 특정 범위 탐색 - 시작과 끝 인덱스 반환
    static int[] searchRange(int[] arr, int target) {
        int[] result = {-1, -1};
        
        // 첫 번째 위치 찾기
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result[0] = mid;
                right = mid - 1; // 더 왼쪽 찾기
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 마지막 위치 찾기
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result[1] = mid;
                left = mid + 1; // 더 오른쪽 찾기
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // 매개 변수 탐색 (Parametric Search) 예시
    static void parametricSearchExample() throws IOException {
        System.out.println("\n매개 변수 탐색 예시: 나무 자르기");
        
        int n = Integer.parseInt(br.readLine()); // 나무 개수
        int m = Integer.parseInt(br.readLine()); // 필요한 나무 길이
        
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }
        
        int result = cutTrees(trees, m, maxHeight);
        System.out.println("절단기 높이: " + result);
    }
    
    // 나무 자르기 - 매개 변수 탐색
    static int cutTrees(int[] trees, int target, int maxHeight) {
        int left = 0;
        int right = maxHeight;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = 0;
            
            // 높이 mid로 잘랐을 때 얻는 나무 길이
            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            
            if (sum >= target) {
                result = mid;
                left = mid + 1; // 더 높게 자를 수 있나 확인
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // 회전된 정렬 배열에서 탐색
    static int searchRotatedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // 왼쪽이 정렬되어 있는 경우
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 오른쪽이 정렬되어 있는 경우
            else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    // 실수 이분 탐색 (제곱근 구하기)
    static double binarySearchDouble(double x) {
        double left = 0.0;
        double right = Math.max(1.0, x);
        double eps = 1e-9; // 정밀도
        
        while (right - left > eps) {
            double mid = (left + right) / 2.0;
            
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}