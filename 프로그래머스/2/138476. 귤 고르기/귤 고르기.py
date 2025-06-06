import collections

def solution(k, tangerine):
    answer = 0
    counter = collections.Counter(tangerine)
    arr = sorted(list(counter.values()))
    cnt = sum(arr)
    if cnt == k:
        return len(arr)
    
    for index, i in enumerate(arr):
        cnt -=i
        if cnt < k:
            return len(arr)-index
        
    return answer