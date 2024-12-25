import collections

def solution(answers):
    person_1 = list(map(int, list('12345')))
    person_2 = list(map(int, list('21232425')))
    person_3 = list(map(int, list('3311224455')))
    people = [person_1, person_2, person_3]
    result = []
    n = len(answers)
    for person in people:
        score = 0
        m = len(person)
        for i in range(n):
            if answers[i] == person[i%m]: score += 1
        result.append(score)

    answer = []
    for idx, val in enumerate(result, start=1):
        if(val == max(result)): answer.append(idx)
    return answer
    