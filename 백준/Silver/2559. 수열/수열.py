import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

arr = list(map(int, input().split()))

ptr = K

sum = sum(arr[:K])
max_sum = sum

for i in range(N - K):
    sum += arr[i + K] - arr[i]
    max_sum = max(max_sum, sum)
print(max_sum)