def solution(keyinput, board):
    width = board[0]//2
    height = board[1]//2
    y,x = 0,0
    map = {'up':(0,1), 'down':(0,-1), 'left':(-1,0), 'right':(1,0)}
    
    def move(y,x,direction):
        dx,dy = map[direction]
        ny,nx = y+dy,x+dx
        if -height<=ny<=height and -width<=nx<=width:
            return (ny,nx)
        return (y,x)

    for direction in keyinput:
        y,x = move(y,x, direction)
        
    return [x,y]