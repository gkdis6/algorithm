import sys
import math
input = sys.stdin.readline

T = int(input().rstrip())
arr = [int(input().rstrip()) for _ in range(T)]

f_arr = [0] * 1000001
sum_arr = [0] * 1000001

for i in range(1, 1000001):
    for j in range(i, 1000001, i):
        f_arr[j] += i

for i in range(1, 1000001):
    sum_arr[i] = sum_arr[i-1] + f_arr[i]

for i in arr:
    print(sum_arr[i])