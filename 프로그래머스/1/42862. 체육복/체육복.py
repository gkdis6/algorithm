def solution(n, lost, reserve):
    common = set(lost) & set(reserve)
    lost = list(set(lost) - common)
    reserve = list(set(reserve) - common)
    
    count = 0
    for i in lost:
        flag = -1
        for j in reserve:    
            if i == j-1 or i == j+1:
                reserve.remove(j)
                flag = 0
                break
        count += flag
    return n + count