import sys

input = sys.stdin.readline

N = int(input().rstrip())

for _ in range(N):
    n = int(input().rstrip())
    A_arr = list(map(int, input().rstrip().split()))
    max_sum = sum(A_arr)
    for i in range(n):
        cur_sum = A_arr[i]
        if max_sum < cur_sum:
                max_sum = cur_sum
        for j in range(i + 1, n):
            cur_sum += A_arr[j]
            if max_sum < cur_sum:
                max_sum = cur_sum
    print(max_sum)