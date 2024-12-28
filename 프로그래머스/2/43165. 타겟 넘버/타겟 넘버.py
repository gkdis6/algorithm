answer = 0

def dfs(numbers, target, idx, val):
    global answer
    if idx == len(numbers):
        if val == target: 
            answer +=1
        return
    dfs(numbers, target, idx+1, val+numbers[idx])
    dfs(numbers, target, idx+1, val-numbers[idx])
    

def solution(numbers, target):
    global answer
    dfs(numbers, target, 0, 0)
    return answer