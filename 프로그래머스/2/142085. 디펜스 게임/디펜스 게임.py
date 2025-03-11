import heapq

def solution(n, k, enemy):
    total = 0
    hq = []
    
    for index, val in enumerate(enemy):
        total += val
        heapq.heappush(hq, -val)
        if total > n:
            if k > 0:
                k -= 1
                total += heapq.heappop(hq)
            else:
                return index

    return len(enemy)