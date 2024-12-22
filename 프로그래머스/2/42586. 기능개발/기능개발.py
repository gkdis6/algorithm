import collections
import math

def solution(progresses, speeds):
    answer = []
    release_day = 0  # 배포가 이루어지는 날

    for progress, speed in zip(progresses, speeds):
        days_needed = math.ceil((100 - progress) / speed)  # 작업 완료까지 걸리는 시간 계산
        if days_needed > release_day:  # 새로운 배포 주기 시작
            release_day = days_needed
            answer.append(1)  # 새 그룹의 첫 작업
        else:  # 같은 배포 주기에 포함
            answer[-1] += 1

    return answer