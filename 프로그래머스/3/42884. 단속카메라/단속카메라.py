def solution(routes):
    answer = 0
    ptr = float('-inf')
    routes.sort(key=lambda x:x[1])
    for start,end in routes:
        if ptr < start:
            answer +=1
            ptr = end
    
    return answer