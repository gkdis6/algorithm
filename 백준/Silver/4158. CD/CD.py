import sys

input = sys.stdin.readline

while True:
    n, m = map(int, input().strip().split())
    if n == 0 and m == 0:
        break
    cd1 = [int(input().strip()) for _ in range(n)]
    cd2 = [int(input().strip()) for _ in range(m)]
    
    i, j, count = 0, 0, 0
    while i < n and j < m:
        if cd1[i] == cd2[j]:
            count += 1
            i += 1
            j += 1
        elif cd1[i] < cd2[j]:
            i += 1
        else:
            j += 1
    print(count)