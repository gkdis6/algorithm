def solution(n):
    total = n * (n + 1) // 2
    triangle = [[0] * (i + 1) for i in range(n)]
    
    dx = [1, 0, -1]
    dy = [0, 1, -1]
    
    x, y = 0, 0
    num = 1
    triangle[x][y] = num
    cur_dir = 0
    
    while num < total:
        nx = x + dx[cur_dir]
        ny = y + dy[cur_dir]
        
        if 0 <= nx < n and 0 <= ny <= nx and triangle[nx][ny] == 0:
            num += 1
            triangle[nx][ny] = num
            x, y = nx, ny
        else:
            cur_dir = (cur_dir + 1) % 3
    
    answer = []
    for row in triangle:
        answer.extend(row)
    return answer
