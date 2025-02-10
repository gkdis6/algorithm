import heapq

def solution(N, road, K):
    graph = [[] for _ in range(N+1)]
    
    distances = [float('inf')]*(N+1)
    distances[1] = 0
    
    for start,end,time in road:
        graph[start].append((end,time))
        graph[end].append((start,time))
        
    heap = []
    heapq.heappush(heap, (1,0))
    while heap:
        node, dist = heapq.heappop(heap)
        
        for next_node, next_dist in graph[node]:
            time = dist + next_dist
            if time < distances[next_node]:
                distances[next_node] = time
                heapq.heappush(heap, (next_node, time))
    
    return sum(1 for dist in distances if dist <= K)