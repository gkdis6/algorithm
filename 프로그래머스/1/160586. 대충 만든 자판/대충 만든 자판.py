def solution(keymap, targets):
    min_index = {}
    for line in keymap:
        for idx, char in enumerate(line, start=1):
            if char not in min_index:
                min_index[char] = idx
            else:
                min_index[char] = min(min_index[char], idx)

    result = []
    for target in targets:
        cur = 0
        for word in target:
            if word not in min_index:
                cur = -1
                break
            cur += min_index[word]
        result.append(cur)
    return result