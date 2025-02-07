import sys

n = int(sys.stdin.readline())

g = list(map(int, sys.stdin.readline().split()))
graph = [[sys.maxsize] *(n) for _ in range(n)]
for _ in range(n-1):
    start, end, cost = map(int, sys.stdin.readline().split())
    graph[start-1][end-1] = cost
    graph[end-1][start-1] = cost

for i in range(n):
    for j in range(n):
        for k in range(n):
            if j==k:
                graph[j][k] = 0
            elif graph[j][k] > graph[j][i] + graph[i][k]:
                graph[j][k] = graph[j][i] + graph[i][k]
    
q = int(sys.stdin.readline())
events = [list(map(int, sys.stdin.readline().split())) for _ in range(q)]

def cluster(where, g):
    cur = 0
    for index, i in enumerate(g):
        cur += graph[index][where-1] * i
    print(cur)

for i in range(q):
    if events[i][0] == 1:
        cluster(events[i][1], g)
    else:
        g[events[i][1]-1] += events[i][2]
