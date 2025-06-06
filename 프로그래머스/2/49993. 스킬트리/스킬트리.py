def solution(skill, skill_trees):
    answer = 0
    for tree in skill_trees:
        ptr = 0
        valid = True
        for ch in tree:
            if ch in skill:
                if ch == skill[ptr]:
                    ptr += 1
                else:
                    valid = False
                    break
        if valid:
            answer += 1
    return answer