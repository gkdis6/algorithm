def solution(order):
    answer = 0
    stack = []
    
    for index, box in enumerate(order, start=1):
        stack.append(index)
        while stack and stack[-1] == order[answer]:
            stack.pop()
            answer += 1
    
    return answer