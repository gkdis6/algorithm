def solution(targets):
    answer = 0
    
    targets.sort(key=lambda x: x[1])
    
    cur = 0
    for left, right in targets:
        if left < cur:
            continue
        else:
            cur = right
            answer += 1
    
    return answer