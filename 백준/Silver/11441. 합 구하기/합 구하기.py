import sys
input = sys.stdin.readline

N = int(input().rstrip())
Arr = [0] + list(map(int,input().strip().split()))
M = int(input().rstrip())

for i in range(1,N+1):
    Arr[i] += Arr[i-1]

for i in range(M):
    a, b = map(int,input().strip().split())
    print(Arr[b] - Arr[a-1])