import sys

N, X = map(int, input().split())

arr = list(map(int, input().split()))

ptr = X

sum = sum(arr[:X])
max_sum = sum
pre_max_count = 1

for i in range(N - X):
    sum += arr[i + X] - arr[i]

    if sum > max_sum:
        max_sum = sum
        pre_max_count = 1
    elif sum == max_sum:
        pre_max_count += 1

print(max_sum if max_sum > 0 else "SAD")
print(pre_max_count if max_sum > 0 else '')