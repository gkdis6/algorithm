def solution(arr):
    n = (len(arr) + 1) // 2
    dp_max = [[-float('inf')] * n for _ in range(n)]
    dp_min = [[float('inf')] * n for _ in range(n)]

    for i in range(n):
        dp_max[i][i] = int(arr[2 * i])
        dp_min[i][i] = int(arr[2 * i])

    for size in range(1, n):
        for i in range(n - size):
            j = i + size
            for k in range(i, j):
                operator = arr[2 * k + 1]
                if operator == '+':
                    dp_max[i][j] = max(dp_max[i][j], dp_max[i][k] + dp_max[k + 1][j])
                    dp_min[i][j] = min(dp_min[i][j], dp_min[i][k] + dp_min[k + 1][j])
                elif operator == '-':
                    dp_max[i][j] = max(dp_max[i][j], dp_max[i][k] - dp_min[k + 1][j])
                    dp_min[i][j] = min(dp_min[i][j], dp_min[i][k] - dp_max[k + 1][j])

    return dp_max[0][n - 1]