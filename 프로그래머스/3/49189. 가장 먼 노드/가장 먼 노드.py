import collections

def solution(n, edge):
    edge.sort()
    que = collections.deque([(1,0)])
    graph = collections.defaultdict(list)
    for start, end in edge:
        graph[start].append(end)
        graph[end].append(start)
    is_visit = [-1]*(n+1)
    is_visit[1] = 0
    while que:
        cur,diff = que.popleft()
        for end in graph[cur]:
            if is_visit[end] == -1:
                is_visit[end] = diff+1
                que.append((end,diff+1))
    return is_visit.count(max(is_visit))