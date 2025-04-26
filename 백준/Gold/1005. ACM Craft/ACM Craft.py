import sys
import collections
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n, k = map(int, input().split())
    cost = [0]+list(map(int, input().split()))

    g = [[] for _ in range(n+1)]
    indeg  = [0]*(n+1)
    for _ in range(k):
        x, y = map(int, input().split())
        g[x].append(y)
        indeg[y] += 1

    w = int(input())

    dp = cost[:]
    q  = collections.deque(i for i in range(1,n+1) if indeg[i] == 0)

    while q:
        cur = q.popleft()
        if cur == w: break
        for nxt in g[cur]:
            if dp[nxt] < dp[cur] + cost[nxt]:
                dp[nxt] = dp[cur] + cost[nxt]
            indeg[nxt]-=1
            if indeg[nxt]==0:
                q.append(nxt)

    print(dp[w])