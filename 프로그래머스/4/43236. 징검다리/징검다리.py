import itertools

def solution(distance, rocks, n):
    rocks.sort()
    left,right = 0,distance
    while left <= right:
        mid = (left + right) // 2
        prev,removed = 0,0
        min_distance = float("inf")
        for rock in rocks:
            if rock - prev < mid:
                removed += 1
            else:
                min_distance = min(min_distance, rock-prev)
                prev = rock
        if distance - prev < mid:
            removed += 1
        if removed > n:
            right = mid -1
        else :
            answer = mid
            left = mid +1
    
    return answer
    