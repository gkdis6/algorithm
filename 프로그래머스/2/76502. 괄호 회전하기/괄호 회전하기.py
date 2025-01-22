from collections import deque

def solution(s):
    answer = 0
    
    def isValid(arr):
        stack = []
        for i in arr:
            if i == '(' or i == '[' or i == '{':
                stack.append(i)
                continue
            elif not stack:
                return False
                
            before = stack.pop()
            if i == ')' and before == '(':
                continue
            elif i == ']' and before == '[':
                continue
            elif i == '}' and before == '{':
                continue
            else:
                return False
        return len(stack) == 0
    
    arr = deque(list(s))
    for _ in range(len(s)):
        arr.rotate(1)
        if isValid(arr):
            answer += 1
    
    return answer