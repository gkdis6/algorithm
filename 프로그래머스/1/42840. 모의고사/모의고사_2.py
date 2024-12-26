import collections

def solution(answers):
    person_1 = list(map(int, list('12345')))
    person_2 = list(map(int, list('21232425')))
    person_3 = list(map(int, list('3311224455')))
    people = [person_1, person_2, person_3]
    scores = [0, 0, 0]
    
    for n, a in enumerate(answers):
        for i, v in enumerate(people):
            if a == v[n%len(v)]: scores[i] += 1
    return [i for i, val in enumerate(scores, start=1) if val==max(scores)]
    
