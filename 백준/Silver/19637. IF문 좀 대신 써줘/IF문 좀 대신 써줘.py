import sys
import bisect

n, m = map(int, sys.stdin.readline().strip().split())
labels = []
thresholds = []

for _ in range(n):
  name, val = sys.stdin.readline().strip().split()
  labels.append(name)
  thresholds.append(int(val))

for _ in range(m):
  x = int(sys.stdin.readline().strip())
  idx = bisect.bisect_left(thresholds, x)
  print(labels[idx])
