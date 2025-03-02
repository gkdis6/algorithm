def solution(order):
    answer = 0
    cur=1
    stack = []
    n = len(order)
    
    for i in order:
        if i == cur:
            answer += 1
            cur +=1
            while stack and stack[-1] == cur:
                stack.pop()
                answer += 1
                cur += 1
        elif stack and i == stack[-1]:
            stack.pop()
            answer +=1
        else:
            while cur <= n and cur != i:
                stack.append(cur)
                cur += 1
            if cur <= n and cur == i:
                answer += 1
                cur += 1
            else:
                break
    
    return answer