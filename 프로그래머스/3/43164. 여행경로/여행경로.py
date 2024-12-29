import collections

def dfs(tickets, result, is_visit):
    if len(result) == len(tickets)+1: return list(result)
    cur = result[-1]
    for idx, (start, end) in enumerate(tickets):
        if not is_visit[idx] and start == cur:
            result.append(end)
            is_visit[idx] = True
            path = dfs(tickets, result, is_visit)
            if path: return path
            result.pop()
            is_visit[idx] = False

def solution(tickets):
    tickets.sort(key=lambda x:(x[1]))
    result = collections.deque(["ICN"])
    n = len(tickets)
    is_visit = [False]*n
    return dfs(tickets, result, is_visit)
    