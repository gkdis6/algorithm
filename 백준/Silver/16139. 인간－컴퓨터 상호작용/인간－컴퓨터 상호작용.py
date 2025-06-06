import sys
from collections import deque

input = sys.stdin.readline

arr = list(input())
a = int(input().strip())

for _ in range(a):
    a, N, K = input().split()
    N = int(N)
    K = int(K)

    print(sum([1 for i in arr[N:K+1] if i == a]))
    