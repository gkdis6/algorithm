def solution(elements):
    answer = set()
    n = len(elements)
    extended = elements * 2

    for i in range(n):
        total = 0
        for j in range(i, i + n):
            total += extended[j]
            answer.add(total)
    
    return len(answer)