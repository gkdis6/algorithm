from itertools import permutations

def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)
        
    answer = len(dist) + 1
    
    for i in range(length):
        for friends in permutations(dist, len(dist)):
            cnt = 1
            position = weak[i] + friends[cnt -1]
            for j in range(i, i+length):
                if position < weak[j]:
                    cnt += 1
                    if cnt > len(dist):
                        break
                    position = weak[j] + friends[cnt - 1]
            answer = min(answer, cnt)
    
    return answer if answer <= len(dist) else -1