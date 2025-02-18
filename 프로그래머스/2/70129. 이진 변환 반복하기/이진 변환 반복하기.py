def solution(s):
    count_transform, count_zero = 0, 0
    
    while s != '1':
        count_transform += 1
        count_zero += s.count('0')
        s = bin(s.count('1'))[2:]
        
    return [count_transform, count_zero]