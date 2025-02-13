def solution(n):
    
    def valid(y, vertical_set, upper_set, lower_set):
        ans = 0
        if y == n:
            ans += 1
        else:
            for i in range(n):
                if vertical_set[i] or upper_set[i+y] or lower_set[i-y+n]:
                    continue
                vertical_set[i] = upper_set[i+y] = lower_set[i-y+n] = True
                ans += valid(y+1, vertical_set, upper_set, lower_set)
                vertical_set[i] = upper_set[i+y] = lower_set[i-y+n] = False
        return ans
    
    return valid(0,[False]*n, [False]*(2*n), [False]*(2*n))
    