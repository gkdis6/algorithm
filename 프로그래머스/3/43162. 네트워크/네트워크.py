import collections

arr = []

def dfs(queue, computers):
    global arr
    
    while queue:
        cur_idx, cur_ptr = queue.popleft()
        arr[cur_idx] = cur_ptr
        for idx, val in enumerate(computers[cur_idx]):
            if val == 1 and arr[idx] != arr[cur_idx]: 
                queue.append([idx, cur_ptr])
    if 0 in arr:
        new_idx = arr.index(0)
        queue.append([new_idx, max(arr)+1])
        dfs(queue, computers)

def solution(n, computers):
    global arr
    arr = [0]*n
    cur = 1
    queue = collections.deque([(0,1)]) #(idx,ptr)
    
    dfs(queue, computers)
    
    return max(arr)