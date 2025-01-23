def solution(board, moves):
    answer = 0
    stack = []
    for move in moves:
        for i in range(len(board)):
            cur = board[i][move-1]
            if cur != 0:
                board[i][move-1] = 0
                if stack and stack[-1] == cur:
                    answer += 2
                    stack.pop()
                else:
                    stack.append(cur)
                break
    
    return answer