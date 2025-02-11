def solution(board):
    def is_valid(x,y):
        return 0<=x<N and 0<=y<N
    
    def is_blocked(x,y):
        return (x,y) == (0,0) or not is_valid(x,y) or board[y][x] == 1
    
    def calculate_cost(direction, prev_direction, cost):
        if prev_direction == -1 or  (prev_direction-direction) %2 ==0:
            return cost+100
        return cost+600
    
    def is_should_update(x,y,direction,new_cost):
        return visited[y][x][direction] == 0 or visited[y][x][direction] > new_cost
    
    queue = [(0,0,-1,0)]
    N = len(board)
    directions = [(0,1), (1,0), (0,-1), (-1,0)]
    visited = [[[0 for _ in range(4)] for _ in range(N)] for _ in range(N)]
    
    answer = float('inf')
    
    while queue:
        x,y,prev_direction, cost = queue.pop(0)
        
        for direction, (dx,dy) in enumerate(directions):
            new_x, new_y = x+dx, y+dy
            if is_blocked(new_x, new_y):
                continue
            
            new_cost = calculate_cost(direction, prev_direction, cost)
            
            if(new_x, new_y) == (N-1, N-1):
                answer = min(answer, new_cost)
            elif is_should_update(new_x,new_y,direction,new_cost):
                queue.append((new_x, new_y, direction,new_cost))
                visited[new_y][new_x][direction] = new_cost
                
    return answer