def solution(n, m, section):
    cur = 0
    cnt = 0
    for i in section:
        if i > cur:
            cur = i + m -1
            cnt += 1
    return cnt