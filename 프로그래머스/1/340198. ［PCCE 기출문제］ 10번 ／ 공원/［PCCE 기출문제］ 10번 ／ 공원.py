def solution(mats, park):
    mats.sort(reverse=True)
    
    rows = len(park)
    cols = len(park[0])
    
    def can_place(mat_size, start_row, start_col):
        if start_row + mat_size > rows or start_col + mat_size > cols:
            return False
        
        for i in range(start_row, start_row + mat_size):
            for j in range(start_col, start_col + mat_size):
                if park[i][j] != "-1":
                    return False
        return True
    
    for mat_size in mats:
        for i in range(rows):
            for j in range(cols):
                if can_place(mat_size, i, j):
                    return mat_size
    
    return -1
