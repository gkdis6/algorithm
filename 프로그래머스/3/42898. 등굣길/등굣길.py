def solution(m, n, puddles):
    dp = [[0]*m for _ in range(n)]
    
    for x,y in puddles:
        dp[y-1][x-1] = -1
        
    for x in range(n):
        for y in range(m):
            if x==0 and y==0: 
                dp[0][0] = 1
                continue
            if dp[x][y] == -1: continue
            left = dp[x-1][y] if x > 0 and dp[x-1][y] != -1 else 0
            up = dp[x][y-1] if y > 0 and dp[x][y-1] != -1 else 0
            dp[x][y] = left + up
    return dp[n-1][m-1] % 1000000007