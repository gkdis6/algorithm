def solution(s, skip, index):
    answer = ''
    for i in s:
        cnt = 0
        cur_char = ord(i)
        while cnt < index:
            cur_char += 1
            if cur_char > ord('z'):
                cur_char = ord('a')
            if chr(cur_char) not in skip:
                cnt += 1
        answer += chr(cur_char)
    return answer
            