# from itertools import permutations
from itertools import product

def solution(word):
    words = 'AEIOU'*5
    list = []
    for i in range(1, 6):
        for j in product(['A','E','I','O','U'], repeat=i):
            list.append("".join(j))
    return sorted(list).index(word)+1
    