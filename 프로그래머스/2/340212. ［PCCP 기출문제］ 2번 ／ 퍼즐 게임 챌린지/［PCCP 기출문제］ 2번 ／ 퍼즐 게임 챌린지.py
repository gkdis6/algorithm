def solution(diffs, times, limit):
    def getTotal(mid):
        total = 0
        prev_time = 0
        for diff,time in zip(diffs,times):
            if diff <=mid:
                total += time
            else:
                total += (diff-mid) * (time + prev_time) + time
            prev_time = time
        if total > limit:
            return False
        return total <= limit
    
    left, right = 1, max(diffs)
    best_mid = right
    while left <= right:
        mid = (left+right)//2
        
        if getTotal(mid):
            best_mid = mid
            right = mid - 1
        else:
            left = mid +1
            
    return best_mid