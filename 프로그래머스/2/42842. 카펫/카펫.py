def solution(brown, yellow):
    sumXY = (brown-4)/2 # 가로 + 세로
    subXY = (sumXY * sumXY  - 4*yellow) ** 0.5 # 가로^2 + 세로^2 + 2*가로*세로
    print(sumXY, subXY)
    return [max(abs((sumXY+subXY)/2), abs((sumXY-subXY)/2))+2, min(abs((sumXY+subXY)/2), abs((sumXY-subXY)/2))+2]