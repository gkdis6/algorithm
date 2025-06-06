import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

P = [0] * (N+1)
for i in range(N):
    P[i+1] = P[i] + arr[i]

total = P[N]
max_sum = 0
for i in range(1, N-1):
    c1 = (P[N] - P[1] - arr[i]) + (P[N] - P[i+1])
    c2 = (P[i+1] - P[1]) + (P[N-1] - P[i])
    c3 = P[i] + (P[N-1] - arr[i])
    max_sum = max(max_sum, c1, c2, c3)

print(max_sum)