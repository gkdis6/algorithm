def solution(storey):
    answer = 0
    while storey > 0:
        digit = storey % 10  # 현재 가장 낮은 자리의 숫자
        storey //= 10        # 가장 낮은 자리 숫자 제거
        
        if digit > 5:
            # 올리는 것이 유리: 10 - digit 만큼 올리고, 남은 숫자에 1을 더함
            answer += (10 - digit)
            storey += 1
        elif digit < 5:
            # 내리는 것이 유리: digit 만큼 내림
            answer += digit
        else:  # digit == 5
            # 5일 때는 남은 숫자(다음 자리)가 5 이상이면 올리는 쪽, 그렇지 않으면 내리는 쪽 선택
            if storey % 10 >= 5:
                answer += (10 - digit)
                storey += 1
            else:
                answer += digit
    return answer