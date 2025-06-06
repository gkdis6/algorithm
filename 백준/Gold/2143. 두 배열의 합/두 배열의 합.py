import sys
import collections
import itertools

input = sys.stdin.readline

T = int(input().rstrip())
n = int(input().rstrip())
A_arr = list(map(int, input().rstrip().split()))
# A_arr = [int(input().rstrip()) for _ in range(n)]
m = int(input().rstrip())
B_arr = list(map(int, input().rstrip().split()))

A_map = collections.defaultdict(int)
B_map = collections.defaultdict(int)

for start in range(n):
    s = 0
    for end in range(start, n):
        s += A_arr[end]
        A_map[s] += 1

for start in range(m):
    s = 0
    for end in range(start, m):
        s += B_arr[end]
        B_map[s] += 1

# print(A_map)
# print(B_map)

result = 0
for i in A_map:
    j = T - i
    if j in B_map:
        # print(result, i , j , A_map[i], B_map[j])
        result += A_map[i] * B_map[j]

print(result)

# 1, 4
# 1, 4
# 2, 3
# 3, 2
# 3, 2
# 4, 1
# 4, 1