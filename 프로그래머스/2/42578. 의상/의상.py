import collections

def solution(clothes):
    counter = collections.Counter(item[1] for item in clothes)
    answer = 1
    for item in counter:
        answer *= counter[item]+1
    return answer-1