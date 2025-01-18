def solution(s):
    answer = [0]*len(s)
    
    for i in range(len(s)):
        for j in range(i+1):
            if s[i] == s[j] and i != j:
                answer[i] = i-j
                continue
        if answer[i] == 0:
            answer[i] = -1
    return answer