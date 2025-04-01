import sys
import bisect

T = int(sys.stdin.readline())
for _ in range(T):
    n, m = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))
    B = list(map(int, sys.stdin.readline().split()))
    B.sort()

    count = 0
    for a in A:
        pos = bisect.bisect_left(B, a)
        count += pos

    print(count)