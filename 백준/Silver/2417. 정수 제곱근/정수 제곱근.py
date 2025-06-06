import sys

n = int(sys.stdin.readline().strip())

ans = int(n**(1/2))
if ans * ans < n:
    ans += 1

print(ans)