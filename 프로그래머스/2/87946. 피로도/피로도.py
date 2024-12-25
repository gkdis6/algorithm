answer = 0
n = 0
visited = []

def dfs(k, cnt, dungeons):
    global answer
    answer = max(answer, cnt)
    
    for i in range(n):
        if k >= dungeons[i][0] and not visited[i]:
            visited[i] = 1
            dfs(k - dungeons[i][1], cnt+1, dungeons)
            visited[i] = 0

def solution(k, dungeons):
    global n, visited
    n = len(dungeons)
    visited = [0] * n
    dfs(k, 0, dungeons)
    return answer