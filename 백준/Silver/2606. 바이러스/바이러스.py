def dfs(graph, start, visited):
    visited.add(start)

    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)

n = int(input().strip())
edges = int(input().strip())
graph = {i: [] for i in range(1, n+1)}

for _ in range(edges):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = set()
dfs(graph, 1, visited)

print(len(visited) - 1)