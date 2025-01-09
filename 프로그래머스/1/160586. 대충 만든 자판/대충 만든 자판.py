def solution(keymap, targets):
    char_to_min_index = {}
    for line in keymap:
        for idx, char in enumerate(line, start=1):
            if char not in char_to_min_index:
                char_to_min_index[char] = idx
            else:
                char_to_min_index[char] = min(char_to_min_index[char], idx)

    result = []
    for target in targets:
        cur = 0
        for word in target:
            if word not in char_to_min_index:
                cur = -1
                break
            cur += char_to_min_index[word]
        result.append(cur)
    
    return result