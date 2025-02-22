from collections import deque

def solution(board):
    n = len(board)
    m = len(board[0])
    
    # 시작 위치와 목표 위치 찾기
    start = None
    target = None
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                start = (i, j)
            elif board[i][j] == 'G':
                target = (i, j)
    
    # 시작 위치가 없거나 목표 위치가 없는 경우 처리 (문제 조건에 따라 생략 가능)
    if not start or not target:
        return -1

    # BFS 초기화
    queue = deque()
    queue.append((start[0], start[1], 0))
    visited = [[False] * m for _ in range(n)]
    visited[start[0]][start[1]] = True

    # 상, 하, 좌, 우 이동
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while queue:
        x, y, moves = queue.popleft()
        
        # 목표에 도달하면 이동 횟수 반환
        if (x, y) == target:
            return moves
        
        # 4가지 방향에 대해 이동 시뮬레이션
        for dx, dy in directions:
            nx, ny = x, y
            # 장애물이나 경계에 닿기 전까지 계속 이동
            while True:
                nx_next = nx + dx
                ny_next = ny + dy
                # 경계를 벗어나거나 장애물이 있으면 멈춤
                if nx_next < 0 or nx_next >= n or ny_next < 0 or ny_next >= m or board[nx_next][ny_next] == 'D':
                    break
                nx, ny = nx_next, ny_next
            
            # 이미 방문한 위치라면 넘어감
            if not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, moves + 1))
    
    # 목표에 도달할 수 없는 경우
    return -1