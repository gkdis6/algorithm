def solution(board, h, w):
    dh, dw = [0, 1, -1, 0], [1, 0, 0, -1]
    n = len(board)
    count = 0
    cur = board[h][w]
    for i in range(4):
        new_h, new_w = h+dh[i],w+dw[i]
        if new_h >= n or new_h < 0 or new_w >= n or new_w < 0: continue
        if cur == board[new_h][new_w]: count += 1
        
    return count