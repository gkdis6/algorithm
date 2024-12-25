import heapq

def solution(jobs):
    tasks = sorted([(x[1],x[0]) for x in jobs], key=lambda x: (x[1], x[0]), reverse=True)
    q = []
    heapq.heappush(q, tasks.pop())
    current, total_response = 0, 0
    while len(q) > 0:
        dur, start = heapq.heappop(q)
        current = max(current, start) + dur
        total_response += current - start
        while len(tasks) > 0 and tasks[-1][1] <= current:
            heapq.heappush(q, tasks.pop())
        # 위에서 current까지의 업무를 더했지만 q에 추가된 업무가 없을 경우
        if len(tasks) > 0 and len(q) == 0:
            heapq.heappush(q, tasks.pop())        
    return total_response // len(jobs)