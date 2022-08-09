# 멀쩡한 사각형

https://school.programmers.co.kr/learn/courses/30/lessons/62048

```java
import java.math.*;

class Solution {
    public long solution(int w, int h) {
        
        int max = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        
        long answer = ((long)w * (long) h) - (long) ((w / max) + (h / max) - 1) * max;
        return answer;
    }
}
```

