import sys

n = int(sys.stdin.readline().strip())
data = list(map(int, input().split()))
limit = int(sys.stdin.readline().strip())

left, right = 0, max(data)
answer = 0

while left <= right:
    mid = (left + right)//2
    total = sum(min(x, mid) for x in data)
    if total <= limit:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1
print(answer)
