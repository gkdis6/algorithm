def solution(h1, m1, s1, h2, m2, s2):
    import bisect
    
    # 하루(0~86400초) 내에서 "초침과 시침이 겹치는 시각" 모두 구하기
    hour_second_times = []
    k = 0
    while True:
        t = (43200/719) * k  # t = (43200/719)*k
        if t >= 86400:
            break
        hour_second_times.append(t)
        k += 1

    # 하루(0~86400초) 내에서 "초침과 분침이 겹치는 시각" 모두 구하기
    minute_second_times = []
    k = 0
    while True:
        t = (3600/59) * k  # t = (3600/59)*k
        if t >= 86400:
            break
        minute_second_times.append(t)
        k += 1

    # 두 리스트 합치기 (정렬 후 '세 바늘 동시 겹침' 중복 제거)
    all_times = hour_second_times + minute_second_times
    all_times.sort()
    
    merged_times = []
    EPS = 1e-9
    for t in all_times:
        if not merged_times:
            merged_times.append(t)
        else:
            if abs(merged_times[-1] - t) < EPS:
                # 같은 시각(실수 오차범위 내)이면 이미 등록된 시간과 동일 취급
                continue
            else:
                merged_times.append(t)

    # 구간 [start, end]로 변경
    start = h1*3600 + m1*60 + s1
    end   = h2*3600 + m2*60 + s2

    # 시작 구간: start 이상인 위치
    left_idx = bisect.bisect_left(merged_times, start)
    # 끝 구간: end 초과가 아닌 (즉 end 이하) 위치까지 포함
    right_idx = bisect.bisect_right(merged_times, end)
    
    return right_idx - left_idx