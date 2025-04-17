import sys
input = sys.stdin.readline

N = int(input().rstrip())
Arr = list(map(int,input().strip().split()))
sum = sum(Arr)

result = 0

for i in Arr:
    result += i*(sum-i)

print(result//2)