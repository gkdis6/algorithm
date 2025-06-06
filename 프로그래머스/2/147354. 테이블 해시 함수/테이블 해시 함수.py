def solution(data, col, row_begin, row_end):
    data.sort(key=lambda x:(x[col-1], -x[0]))
    arr = []
    for i in range(row_begin-1, row_end):
        ptr = 0
        for j in data[i]:
            ptr += j%(i+1)
        arr.append(ptr)
    
    result = 0
    for num in arr:
        result ^= num
        
    return result