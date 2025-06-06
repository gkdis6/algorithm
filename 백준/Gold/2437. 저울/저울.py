import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().rstrip().split()))
arr.sort()

current_sum = 0
for weight in arr:
    if weight > current_sum + 1:
        break
    current_sum += weight

print(current_sum + 1)
