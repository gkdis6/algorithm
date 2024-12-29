from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    queue = deque([(0, 0, 1)])  # (x, y, step)
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True

    while queue:
        cur_x, cur_y, step = queue.popleft()

        if cur_x == m - 1 and cur_y == n - 1:
            return step

        for dx, dy in directions:
            new_x, new_y = cur_x + dx, cur_y + dy

            if 0 <= new_x < m and 0 <= new_y < n and maps[new_y][new_x] == 1 and not visited[new_y][new_x]:
                visited[new_y][new_x] = True
                queue.append((new_x, new_y, step + 1))

    return -1