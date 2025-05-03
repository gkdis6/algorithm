import sys

input = sys.stdin.readline

N = int(input().strip())
arr = list(map(int, input().split()))
Q = int(input().strip())

score = [0] * N
for i in range(1, N):
    score[i] = score[i-1] + (1 if arr[i-1] > arr[i] else 0)
    
for _ in range(Q):
    x, y = map(int, input().split())
    if x == y:
        print(0)
    else:
        print(score[y-1] - score[x-1])