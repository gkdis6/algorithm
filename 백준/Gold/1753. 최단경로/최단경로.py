import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())
start = int(input()) - 1 

graph = [[] for _ in range(V)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u-1].append((v-1, w))

INF = float('inf')
distance = [INF] * V
distance[start] = 0

heap = []
heapq.heappush(heap, (0, start))

while heap:
    dist, cur = heapq.heappop(heap)
    if dist > distance[cur]:
        continue
    for next_node, weight in graph[cur]:
        new_dist = dist + weight
        if new_dist < distance[next_node]:
            distance[next_node] = new_dist
            heapq.heappush(heap, (new_dist, next_node))

for d in distance:
    print(d if d != INF else "INF")