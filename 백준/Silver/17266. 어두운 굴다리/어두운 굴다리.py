import sys, math

n = int(sys.stdin.readline().strip())
m = int(sys.stdin.readline().strip())

arr = list(map(int, sys.stdin.readline().strip().split()))
arr.append(n)

start = 0

max_diff = 0
for index, i in enumerate(arr):
  if index == 0 or index == m:
    max_diff = max(max_diff, i-start)
  else:
    max_diff = max(max_diff, math.ceil((i-start)/2))
  start = i

print(max_diff)