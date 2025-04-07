import sys
import bisect

n, m = map(int, sys.stdin.readline().strip().split())
dots = list(map(int, sys.stdin.readline().strip().split()))
dots.sort()

for _ in range(m):
  x, y = map(int, sys.stdin.readline().strip().split())
  left_index = bisect.bisect_left(dots, x)   # x 이상인 가장 왼쪽 위치
  right_index = bisect.bisect_right(dots, y)   # y 초과인 첫번째 위치
  print(right_index - left_index)


