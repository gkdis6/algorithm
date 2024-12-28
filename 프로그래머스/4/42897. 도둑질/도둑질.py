def solution(money):
    n = len(money)
    first = [-float('inf')]*n
    second = [-float('inf')]*n
    answer = 0
    if n < 3:
        for i in range(3):
            answer = max(answer, money[i])
        return answer
    
    first[0],first[1] = money[0], max(money[0], money[1])
    second[0],second[1] = 0, money[1]
    
    for i in range(2,n):
        if i != n-1: first[i] = max(first[i-1], first[i-2]+money[i])
        second[i] = max(second[i-1], second[i-2]+money[i])
    return max(first[n-2], second[n-1])