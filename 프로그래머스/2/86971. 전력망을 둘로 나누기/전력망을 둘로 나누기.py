from collections import defaultdict, deque

def solution(n, wires):
    def bfs(start, graph, visited):
        queue = deque([start])
        visited[start] = True
        count = 1
        while queue:
            node = queue.popleft()
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)
                    count += 1
        return count

    min_difference = float('inf')
    graph = defaultdict(list)
    
    for u, v in wires:
        graph[u].append(v)
        graph[v].append(u)

    for u, v in wires:
        graph[u].remove(v)
        graph[v].remove(u)

        visited = [False] * (n + 1)
        count1 = bfs(1, graph, visited)
        count2 = n - count1

        min_difference = min(min_difference, abs(count1 - count2))

        graph[u].append(v)
        graph[v].append(u)
    
    return min_difference