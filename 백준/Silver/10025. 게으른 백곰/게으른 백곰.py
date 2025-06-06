import sys

input = sys.stdin.readline

N, K = map(int, input().split())

ice_buckets = []
for _ in range(N):
    g, x = map(int, input().split())
    ice_buckets.append((g, x))

if not ice_buckets:
    print(0)
    exit(0)

max_pos = max(x for _, x in ice_buckets)

ice_amount = [0] * (max_pos + 1)
for g, x in ice_buckets:
    ice_amount[x] += g

window_size = 2 * K + 1

current_sum = 0
for i in range(min(window_size, max_pos + 1)):
    current_sum += ice_amount[i]

max_sum = current_sum

for i in range(window_size, max_pos + 1):
    current_sum = current_sum - ice_amount[i - window_size] + ice_amount[i]
    max_sum = max(max_sum, current_sum)

print(max_sum)
