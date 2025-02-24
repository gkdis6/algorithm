def solution(info, n, m):
    dp = [[False] * m for _ in range(n)]
    dp[0][0] = True
    
    for a_val, b_val in info:
        next_dp = [[False] * m for _ in range(n)]
        for a in range(n):
            for b in range(m):
                if dp[a][b]:
                    if a + a_val < n:
                        next_dp[a + a_val][b] = True
                    if b + b_val < m:
                        next_dp[a][b + b_val] = True
        dp = next_dp
    
    return min((a for a in range(n) for b in range(m) if dp[a][b]), default=-1)
