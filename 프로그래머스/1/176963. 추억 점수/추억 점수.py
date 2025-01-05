def solution(name, yearning, photo):
    scores = {first:yearn for first, yearn in zip(name,yearning)}
    result = []
    for people in photo:
        cnt = 0
        for person in people:
            if person in scores:
                cnt += scores[person]
        result.append(cnt)
    return result