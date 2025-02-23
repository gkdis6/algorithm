def solution(players, m, k):
    answer = 0
    len_arr = len(players)
    arr = [0]*len_arr
    
    for index,i in enumerate(players):
        if arr[index] < i//m:
            cur = arr[index]
            answer += i//m-cur
            for j in range(index,min(index+k,len_arr)):
                arr[j] += (i//m-cur)
    
    return answer