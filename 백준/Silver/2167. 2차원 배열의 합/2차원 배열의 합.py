import sys
import collections
input = sys.stdin.readline

R, C = map(int, input().split())

arr = [[0] * (C + 1)]
arr += [[0] + list(map(int,input().rstrip().split())) for _ in range(R)]

acc_sum = [[0] * (C + 1) for _ in range(R + 1)]

for i in range(1, R + 1):
    for j in range(1, C + 1):
        acc_sum[i][j] = acc_sum[i - 1][j] + acc_sum[i][j - 1] - acc_sum[i - 1][j - 1] + arr[i][j]

Q = int(input())
for j in range(Q):
    r1, c1, r2, c2 = map(int, input().split())
    ans = acc_sum[r2][c2] - acc_sum[r1 - 1][c2] - acc_sum[r2][c1 - 1] + acc_sum[r1 - 1][c1 - 1]
    print(ans)