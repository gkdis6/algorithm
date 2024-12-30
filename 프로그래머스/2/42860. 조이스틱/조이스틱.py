def solution(name):
    n = len(name)
    move = n - 1

    answer = 0
    for i, char in enumerate(name):
        answer += min(ord(char) - ord('A'), ord('Z') - ord(char) + 1)

        next_idx = i + 1
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1

        move = min(move, i + i + n - next_idx)
        move = min(move, i + (n - next_idx) * 2)

    answer += move
    return answer