import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    n = 0
    while len(scoville) > 1:
        min1 = heapq.heappop(scoville)
        if min1 >= K:
            return n
        
        min2 = heapq.heappop(scoville)
        heapq.heappush(scoville, min1 + min2 * 2)
        n += 1
    return n if scoville[0] >= K else -1