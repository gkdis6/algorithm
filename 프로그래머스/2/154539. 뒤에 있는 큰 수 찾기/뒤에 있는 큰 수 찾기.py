def solution(numbers):
    answer = [-1] * len(numbers)
    stack = []
    cur = -1
    for i, current in enumerate(numbers):
        while stack and numbers[stack[-1]] < current:
            index = stack.pop()
            answer[index] = current
        stack.append(i)
    return answer