import sys

input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, list(input().strip()))) for _ in range(N)]

sum_board = [[0] * (M + 1) for _ in range(N + 1)]
for i in range(N):
    for j in range(M):
        sum_board[i + 1][j + 1] = sum_board[i][j + 1] + sum_board[i + 1][j] - sum_board[i][j] + board[i][j]

def get_sum(r1, c1, r2, c2):
    return sum_board[r2 + 1][c2 + 1] - sum_board[r1][c2 + 1] - sum_board[r2 + 1][c1] + sum_board[r1][c1]

max_product = 0

# 1. 세로로 3등분
for c1 in range(M - 2):
    for c2 in range(c1 + 1, M - 1):
        s1 = get_sum(0, 0, N - 1, c1)
        s2 = get_sum(0, c1 + 1, N - 1, c2)
        s3 = get_sum(0, c2 + 1, N - 1, M - 1)
        max_product = max(max_product, s1 * s2 * s3)

# 2. 가로로 3등분
for r1 in range(N - 2):
    for r2 in range(r1 + 1, N - 1):
        s1 = get_sum(0, 0, r1, M - 1)
        s2 = get_sum(r1 + 1, 0, r2, M - 1)
        s3 = get_sum(r2 + 1, 0, N - 1, M - 1)
        max_product = max(max_product, s1 * s2 * s3)

# 3. 가로로 1등분, 남은 부분을 세로로 2등분 (윗 부분을 세로 분할)
for r1 in range(N - 1):
    for c1 in range(M - 1):
        s1 = get_sum(0, 0, r1, c1)
        s2 = get_sum(0, c1 + 1, r1, M - 1)
        s3 = get_sum(r1 + 1, 0, N - 1, M - 1)
        max_product = max(max_product, s1 * s2 * s3)

# 4. 가로로 1등분, 남은 부분을 세로로 2등분 (아랫 부분을 세로 분할)
for r1 in range(N - 1):
    for c1 in range(M - 1):
        s1 = get_sum(0, 0, r1, M - 1)
        s2 = get_sum(r1 + 1, 0, N - 1, c1)
        s3 = get_sum(r1 + 1, c1 + 1, N - 1, M - 1)
        max_product = max(max_product, s1 * s2 * s3)

# 5. 세로로 1등분, 남은 부분을 가로로 2등분 (왼쪽 부분을 가로 분할)
for c1 in range(M - 1):
    for r1 in range(N - 1):
        s1 = get_sum(0, 0, r1, c1)
        s2 = get_sum(r1 + 1, 0, N - 1, c1)
        s3 = get_sum(0, c1 + 1, N - 1, M - 1)
        max_product = max(max_product, s1 * s2 * s3)

# 6. 세로로 1등분, 남은 부분을 가로로 2등분 (오른쪽 부분을 가로 분할)
for c1 in range(M - 1):
    for r1 in range(N - 1):
        s1 = get_sum(0, 0, N - 1, c1)
        s2 = get_sum(0, c1 + 1, r1, M - 1)
        s3 = get_sum(r1 + 1, c1 + 1, N - 1, M - 1)
        max_product = max(max_product, s1 * s2 * s3)

print(max_product)