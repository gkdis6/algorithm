def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []
    
    for i, price in enumerate(prices):
        while stack and stack[-1][0] > price:
            _, idx = stack.pop()
            answer[idx] = i - idx
        stack.append((price, i))
    
    while stack:
        _, idx = stack.pop()
        answer[idx] = n - 1 - idx  # 끝까지 유지된 기간
    
    return answer