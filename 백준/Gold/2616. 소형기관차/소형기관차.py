import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
M = int(input())

S = [0] * (N+1)
for i in range(N):
    S[i+1] = S[i] + arr[i]

dp = [[0] * (N+1) for _ in range(4)]

max_far = [[0] * (N+1) for _ in range(4)]

for i in range(1,4):
    start_k_prev = (i - 1) * M
    if i > 1:
        pass
        for k in range(start_k_prev, N+1):
            if k > start_k_prev:
                max_far[i - 1][k] = max(max_far[i - 1][k - 1], dp[i - 1][k])
            else:
                max_far[i - 1][k] = dp[i - 1][k]
    for j in range(i*M, N+1):
        current_train_passengers = S[j] - S[j - M]
        if i == 1:
            dp[1][j] = current_train_passengers
        else:
            dp[i][j] = current_train_passengers + max_far[i - 1][j - M]
start_k_final = 3 * M
if start_k_final <= N:
    for k in range(start_k_final, N + 1):
        if k > start_k_final:
            max_far[3][k] = max(max_far[3][k - 1], dp[3][k])
        else: 
            max_far[3][k] = dp[3][k]
    print(max_far[3][N])
else:
    print(0)
