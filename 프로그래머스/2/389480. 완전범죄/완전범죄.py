def solution(info, n, m):
    info.sort(key=lambda x: x[0]/x[1], reverse=True)
    sum_a, sum_b = 0,0
    for a,b in info:
        if sum_b + b < m:
            sum_b +=b
        elif sum_a + a < n:
            sum_a +=a
        else:
            return -1
        
    return sum_a