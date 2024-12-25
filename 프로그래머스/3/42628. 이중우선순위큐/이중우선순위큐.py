import heapq

def solution(operations):
    q = []
    for operation in operations:
        if operation[0] == 'I':
            heapq.heappush(q, int(operation[2:]))
        elif operation[0] == 'D':
            if len(q) == 0: continue
            elif operation[2:] == '-1':
                heapq.heappop(q)
            else:
                largest = heapq.nlargest(1, q)[0]
                q.remove(largest)
    if len(q) < 1 : return [0,0]
    return[heapq.nlargest(1, q)[0],heapq.heappop(q)]