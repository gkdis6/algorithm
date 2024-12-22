def solution(arr):
    result = []
    for i in range(len(arr)-1):
        if arr[i] != arr[i+1]:
            result.append(arr[i])
        i += 1
    result.append(arr[-1])
    return result