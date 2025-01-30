def solution(id_list, report, k):
    report = set(report)  # 중복 신고 제거
    reports = {user: set() for user in id_list}  # 신고 기록 저장
    report_count = {user: 0 for user in id_list}  # 신고당한 횟수 저장

    # 신고 기록 저장
    for r in report:
        reporter, reported = r.split()
        reports[reporter].add(reported)
        report_count[reported] += 1

    # 정지된 유저 목록
    banned = {user for user, count in report_count.items() if count >= k}

    # 결과 메일 개수 계산
    answer = [len(reports[user] & banned) for user in id_list]

    return answer