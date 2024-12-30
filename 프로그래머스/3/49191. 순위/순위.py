def solution(n, results):
    graph = [[0] * (n + 1) for _ in range(n + 1)]
    
    for winner, loser in results:
        graph[winner][loser] = 1  # 승리
        graph[loser][winner] = -1  # 패배

    for k in range(1, n + 1):  # 중간 노드
        for i in range(1, n + 1):  # 출발 노드
            for j in range(1, n + 1):  # 도착 노드
                if graph[i][k] == 1 and graph[k][j] == 1:
                    graph[i][j] = 1
                elif graph[i][k] == -1 and graph[k][j] == -1:
                    graph[i][j] = -1

    count = 0
    for i in range(1, n + 1):
        known_results = sum(1 for j in range(1, n + 1) if graph[i][j] != 0)
        if known_results == n - 1:
            count += 1

    return count