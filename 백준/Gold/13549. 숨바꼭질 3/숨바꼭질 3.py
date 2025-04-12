from collections import deque
import sys

def find_min_time(N, K):
    MAX = 100001  
    INF = float('inf')
    time = [INF] * MAX
    time[N] = 0
    
    dq = deque()
    dq.append(N)
    
    while dq:
        x = dq.popleft()
        if x == K:
            return time[x]
        
        next_pos = 2 * x
        if 0 <= next_pos < MAX and time[next_pos] > time[x]:
            time[next_pos] = time[x]
            dq.appendleft(next_pos)
        
        for next_pos in (x - 1, x + 1):
            if 0 <= next_pos < MAX and time[next_pos] > time[x] + 1:
                time[next_pos] = time[x] + 1
                dq.append(next_pos)
                
    return time[K]

if __name__ == '__main__':
    input = sys.stdin.readline
    N, K = map(int, input().split())
    print(find_min_time(N, K))