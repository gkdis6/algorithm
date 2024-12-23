import collections

def solution(priorities, location):
    queue = collections.deque([(priority, idx) for idx, priority in enumerate(priorities)])
    order = 0
    while queue:
        current = queue.popleft()
        if any(current[0] < q[0] for q in queue):
            queue.append(current)
        else:
            order += 1
            if current[1] == location:
                return order
    
    
