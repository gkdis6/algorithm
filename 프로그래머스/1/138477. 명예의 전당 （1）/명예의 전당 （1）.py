import heapq

def solution(k, score):
    answer = []
    loop = []
    for i in score:
        if len(loop) < k:
            heapq.heappush(loop, i)
        else :
            heapq.heappushpop(loop, i)
        answer.append(heapq.nsmallest(1,loop)[0])
    return answer