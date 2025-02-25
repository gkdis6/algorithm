import sys
sys.setrecursionlimit(10**6)

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    answer = []
    
    visited = [[False] * m for _ in range(n)]
    
    def dfs(r, c):
        if r < 0 or r >= n or c < 0 or c >= m:
            return 0
        if visited[r][c] or maps[r][c] == 'X':
            return 0
        visited[r][c] = True
        total = int(maps[r][c])
        for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            total += dfs(r + dr, c + dc)
        return total

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and maps[i][j] != 'X':
                answer.append(dfs(i, j))
    
    return sorted(answer) if answer else [-1]