def solution(arr):
    result = []
    for item in arr:
        if result[-1:] != [item]:
            result.append(item)
    return result