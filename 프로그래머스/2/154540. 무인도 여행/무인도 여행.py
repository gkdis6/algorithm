import collections

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    answer = []
    
    visited = [[False] * m for _ in range(n)]
    q = collections.deque()
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'X' or visited[i][j]:
                continue
            q.append((i,j))
            visited[i][j] = True
            food = int(maps[i][j])
            while q:
                y,x = q.popleft()
                for dy, dx in [(1,0), (0,1), (-1,0), (0,-1)]:
                    ny, nx = y+dy, x+dx
                    if 0<=ny<n and 0<=nx<m and not visited[ny][nx] and maps[ny][nx] != 'X':
                        q.append((ny,nx))
                        visited[ny][nx] = True
                        food += int(maps[ny][nx])
            answer.append(food)
    return sorted(answer) if answer else [-1]
