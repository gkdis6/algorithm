import java.io.*;
import java.util.*;

class Sorting_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 여러 정렬 알고리즘 테스트
        System.out.println("원본 배열: " + Arrays.toString(arr));
        
        int[] temp = arr.clone();
        quickSort(temp, 0, n - 1);
        System.out.println("퀵소트: " + Arrays.toString(temp));
        
        temp = arr.clone();
        mergeSort(temp, 0, n - 1);
        System.out.println("병합정렬: " + Arrays.toString(temp));
        
        temp = arr.clone();
        heapSort(temp);
        System.out.println("힙정렬: " + Arrays.toString(temp));
    }
    
    // 퀵소트
    // Time Complexity: O(n log n) average case, O(n^2) worst case
    // Space Complexity: O(log n) for recursion stack
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // O(n)
            quickSort(arr, low, pivot - 1);       // T(n/2)
            quickSort(arr, pivot + 1, high);      // T(n/2)
        }
    }
    
    // Partition function - O(n)
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {      // O(n)
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);                   // O(1)
            }
        }
        
        swap(arr, i + 1, high);                 // O(1)
        return i + 1;
    }
    
    // 병합정렬
    // Time Complexity: O(n log n) guaranteed
    // Space Complexity: O(n) for temporary arrays
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);          // T(n/2)
            mergeSort(arr, mid + 1, right);     // T(n/2)
            merge(arr, left, mid, right);       // O(n)
        }
    }
    
    // Merge function - O(n)
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];  // O(n) space
        int[] R = new int[n2];  // O(n) space
        
        // Copy data to temp arrays - O(n)
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        // Merge arrays - O(n)
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements - O(n)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // 힙정렬
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    static void heapSort(int[] arr) {
        int n = arr.length;
        
        // 힙 구성 - O(n)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);     // O(log n)
        }
        
        // 하나씩 추출 - O(n log n)
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);        // O(1)
            heapify(arr, i, 0);     // O(log n)
        }
    }
    
    // Heapify function - O(log n)
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);      // O(1)
            heapify(arr, n, largest);   // O(log n) recursion
        }
    }
    
    // Swap function - O(1)
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}