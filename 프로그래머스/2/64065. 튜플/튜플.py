def solution(s):
    answer = []
    s = s[2:-2].split('},{')
    s = sorted(s, key=len)
    
    for i in s:
        numbers = i.split(',')
        for number in numbers:
            if int(number) not in answer:
                answer.append(int(number))
                
    return answer