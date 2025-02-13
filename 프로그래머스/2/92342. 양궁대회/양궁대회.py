from itertools import combinations_with_replacement
from collections import Counter

def solution(n, info):
    max_diff, max_comb = 0, {}
    
    def cal_score(comb):
        score1, score2 = 0,0
        for i in range(1, 11):
            if info[10-i] < comb.count(i):
                score1 +=i
            elif info[10-i] > 0:
                score2 +=i
        return score1, score2
    
    def cal_diff(diff, cnt):
        nonlocal max_diff, max_comb
        if diff > max_diff:
            max_diff = diff
            max_comb = cnt
    
    for combi in combinations_with_replacement(range(11), n):
        cnt = Counter(combi)
        score1, score2 = cal_score(combi)
        diff = score1 - score2
        cal_diff(diff, cnt)
        
    if max_diff > 0:
        answer = [0] *11
        for n in max_comb:
            answer[10-n] = max_comb[n]
        return answer
    else:
        return [-1]
            