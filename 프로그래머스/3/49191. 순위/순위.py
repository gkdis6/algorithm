import collections

def solution(n, results):
    win = collections.defaultdict(set)
    lose = collections.defaultdict(set)
    
    for winner, loser in results:
        win[winner].add(loser)
        lose[loser].add(winner)
    
    for i in range(1, n + 1):
        for winner in lose[i]:
            win[winner].update(win[i])  # 이긴 사람의 패배자 리스트 갱신
        for loser in win[i]:
            lose[loser].update(lose[i])  # 진 사람의 승리자 리스트 갱신
    
    count = 0
    for i in range(1, n + 1):
        if len(set(win[i])) + len(set(lose[i])) == n - 1:  # 자신을 제외한 모든 플레이어와 연결된 경우
            count += 1
    
    return count