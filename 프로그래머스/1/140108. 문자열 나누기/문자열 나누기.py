def solution(s):
    answer = 0
    len_s = len(s)
    
    prev = ''
    cnt = 0
    reverse_cnt = 0
    i = 0
    while i < len_s:
        if cnt == 0:
            cnt = 1
            prev = s[i]
        elif prev == s[i]:
            cnt += 1
        elif reverse_cnt == cnt-1 :
            answer += 1
            cnt = 0
            reverse_cnt = 0
        else :
            reverse_cnt += 1
        i += 1
    if cnt > 0:
        answer += 1
    return answer