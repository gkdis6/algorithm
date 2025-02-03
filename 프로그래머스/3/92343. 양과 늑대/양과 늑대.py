from collections import deque

def solution(info, edges):
    children = [[] for _ in range(len(info))]
    
    for parent,child in edges:
        children[parent].append(child)
    
    max_sheep = 0
    q = deque([(0,1,0, set())])
    
    while q:
        cur, sheep, wolf, visited = q.popleft()
        max_sheep = max(max_sheep, sheep)
        
        visited.update(children[cur])
        
        for next_node in visited:
            if info[next_node]:
                if sheep != wolf + 1:
                    q.append((next_node, sheep, wolf+1, visited - {next_node}))
                continue
            q.append((next_node, sheep+1, wolf, visited - {next_node}))
    
    return max_sheep