def solution(arrows):
    moves = [
        (0, 1), (1, 1), (1, 0), (1, -1),
        (0, -1), (-1, -1), (-1, 0), (-1, 1)
    ]
    
    # 방문한 노드와 간선을 기록할 집합
    visited_nodes = set()
    visited_edges = set()
    
    x, y = 0, 0
    visited_nodes.add((x, y))
    answer = 0
    
    for arrow in arrows:
        dx, dy = moves[arrow]
        # 한 번의 이동을 두 번의 단위 이동으로 나눔
        for _ in range(2):
            nx = x + dx
            ny = y + dy
            
            # 현재 좌표에서 다음 좌표로의 간선 정보를 생성
            edge = ((x, y), (nx, ny))
            
            # 만약 이 간선이 처음 방문하는 간선이라면
            if edge not in visited_edges:
                # 양방향 간선 모두 추가 (A→B, B→A)
                visited_edges.add(edge)
                visited_edges.add(((nx, ny), (x, y)))
                # 다음 노드가 이미 방문한 적 있다면, 새로운 방(사이클) 형성
                if (nx, ny) in visited_nodes:
                    answer += 1
                    
            # 노드 방문 체크 (이미 방문했어도 집합에 추가해도 무방)
            visited_nodes.add((nx, ny))
            # 현재 좌표 업데이트
            x, y = nx, ny
    
    return answer