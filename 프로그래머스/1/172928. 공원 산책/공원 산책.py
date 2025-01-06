def solution(park, routes):
    direction_x = {"E":1, "N":0, "S":0, "W":-1}
    direction_y = {"E":0, "N":-1, "S":1, "W":0}
    len_y = len(park)
    len_x = len(park[0])
    def go(direction, cur_y, cur_x, length):
        dir_y, dir_x = direction_y[direction], direction_x[direction]
        if cur_y + dir_y*length <0 or cur_y + dir_y*length >= len_y or cur_x + dir_x*length <0 or cur_x + dir_x*length >= len_x : return cur_y, cur_x
        for i in range(1,length+1):
            if park[cur_y + dir_y*i][cur_x + dir_x*i] == 'X': return cur_y, cur_x
        return cur_y + dir_y*length, cur_x + dir_x*length
    
    cur_x, cur_y = 0,0
    for y,line in enumerate(park):
        for x,i in enumerate(line):
            if i == 'S': 
                cur_y,cur_x = y,x
    
    for route in routes:
        direction = route[0]
        length = int(route[2])
        cur_y, cur_x = go(direction, cur_y, cur_x, length)
        
    return [cur_y, cur_x]