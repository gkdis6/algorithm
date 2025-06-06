def solution(arr1, arr2):
    n, m, k = len(arr1), len(arr1[0]), len(arr2[0])
    answer = [[0] * k for _ in range(n)]

    for i in range(n):
        for j in range(k):
            for x in range(m):
                answer[i][j] += arr1[i][x] * arr2[x][j]

    return answer