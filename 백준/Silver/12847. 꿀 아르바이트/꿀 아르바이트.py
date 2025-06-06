import sys

input = sys.stdin.readline

n, m = map(int, input().split())

if n == 0:
    print(0)
else:
    pays = list(map(int, input().split()))
    if m == 0:
        print(0)
    elif n < m:
         pass 
    current_sum = sum(pays[0:m])
    max_sum = current_sum

    for i in range(m, n):
        current_sum = current_sum - pays[i - m] + pays[i]
        max_sum = max(max_sum, current_sum)

    print(max_sum)