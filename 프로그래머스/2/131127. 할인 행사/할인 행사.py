def solution(want, number, discount):
    answer = 0
    
    want_dic = {}
    for i in range(len(want)):
        want_dic[want[i]] = number[i]
        
    for i in range(len(discount) - 9):
        discount_10d = {}
        
        for j in range(i, i+10):
            if discount[j] in want_dic:
                discount_10d[discount[j]] = discount_10d.get(discount[j], 0) +1
        if discount_10d == want_dic:
            answer += 1
    return answer