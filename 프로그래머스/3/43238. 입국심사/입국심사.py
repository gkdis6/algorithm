def solution(n, times):
    times.sort()
    left = 0
    right = times[-1]*n
    answer = 0
    while left <= right:
        mid = (left + right)//2
        ptr = 0
        for time in times:
            ptr += mid//time
        if ptr >= n: 
            right = mid - 1
            answer = mid
        else : left = mid + 1
    return answer