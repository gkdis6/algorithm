def solution(elements):
    answer = set()
    n = len(elements)

    for i in range(n):
        total = 0
        for j in range(i, i + n):
            total += elements[j%n]
            answer.add(total)
    
    return len(answer)