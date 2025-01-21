import collections

def solution(land):
    n = len(land)
    m = len(land[0])
    visited = [[False] * m for _ in range(n)]
    oil_per_column = [0] * m

    def bfs(x, y):
        queue = collections.deque([(x, y)])
        visited[x][y] = True
        oil_size = 0
        min_col, max_col = y, y

        while queue:
            cx, cy = queue.popleft()
            oil_size += 1
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and land[nx][ny] == 1:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
                    min_col = min(min_col, ny)
                    max_col = max(max_col, ny)

        for col in range(min_col, max_col + 1):
            oil_per_column[col] += oil_size

    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                bfs(i, j)

    return max(oil_per_column)