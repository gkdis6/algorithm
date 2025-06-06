import sys
from collections import deque

k = int(sys.stdin.readline())
for _ in range(k):
    n, m = map(int,sys.stdin.readline().split())
    queue = deque(enumerate(map(int, sys.stdin.readline().split())))
    count = 0

    while queue:
        cur = queue.popleft()
        if any(cur[1] < other[1] for other in queue):
            queue.append(cur)
        else:
            count += 1
            if cur[0] == m:
                print(count)
                break
