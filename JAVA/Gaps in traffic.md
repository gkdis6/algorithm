- 

```java
public static int widestGap(int n, List<Integer> start, List<Integer> finish) {
        int[] path = new int[n];
        
        for(int i = 0; i<n; i++){
            path[i] = 0;
        }
        
        for(int i = 0; i<start.size(); i++){
            for(int j = start.get(i)-1; j<finish.get(i); j++){
                path[j]++;
            }
        }
        int max = 0;
        for(int i = 0, count = 0; i<n; i++){
            while(i<n && path[i] == 0){
                System.out.println(path[i]);
                count++;
                i++;
            }
            if(max<count){
                max = count;
            }
            count = 0;
        }
        return max;
    }
```

