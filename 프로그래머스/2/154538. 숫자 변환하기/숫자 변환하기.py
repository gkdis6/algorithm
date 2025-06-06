import collections

def solution(x, y, n):
    if x == y:
        return 0

    queue = collections.deque([(0, x)])
    visited = {x}

    while queue:
        count, cur = queue.popleft()
        if cur == y:
            return count

        for next_val in (cur + n, cur * 2, cur * 3):
            if next_val <= y and next_val not in visited:
                visited.add(next_val)
                queue.append((count + 1, next_val))
    
    return -1