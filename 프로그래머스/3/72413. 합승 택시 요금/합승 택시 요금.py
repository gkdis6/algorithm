def solution(n, s, a, b, fares):
    INF = float('inf')
    
    dist = [[INF] * (n + 1) for _ in range(n + 1)]
    
    for i in range(1, n + 1):
        dist[i][i] = 0
    
    for c1, c2, fare in fares:
        dist[c1][c2] = fare
        dist[c2][c1] = fare
    
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    
    answer = INF
    for x in range(1, n + 1):
        cost = dist[s][x] + dist[x][a] + dist[x][b]
        answer = min(answer, cost)
    
    return answer