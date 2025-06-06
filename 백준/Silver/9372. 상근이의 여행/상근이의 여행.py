import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
  n,m = map(int, sys.stdin.readline().strip().split())
  arr = []
  for _ in range(m):
    start,end = map(int, sys.stdin.readline().strip().split())
  print(n-1)
