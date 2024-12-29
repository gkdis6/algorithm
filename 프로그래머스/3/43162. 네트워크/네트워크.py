import collections


def dfs(queue, computers, arr):
    while queue:
        cur_idx, cur_ptr = queue.popleft()
        arr[cur_idx] = cur_ptr
        for idx, val in enumerate(computers[cur_idx]):
            if val == 1 and arr[idx] == 0:
                queue.append([idx, cur_ptr])

def solution(n, computers):
    arr = [0]*n
    cur = 1
    for i in range(n):
        if arr[i] == 0:
            queue = collections.deque([(i, cur)])
            dfs(queue, computers, arr)
            cur += 1
    return cur - 1