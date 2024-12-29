import collections

def solution(begin, target, words):
    if target not in words: return 0
    que = collections.deque([(begin,0)])
    visited = [False] * len(words)
    while que:
        cur, step = que.popleft()
        if cur == target: return step
        for idx, word in enumerate(words):
            diff = sum([1 for i,j in zip(cur, word) if i != j])
            if not visited[idx] and diff == 1: #and 바꿀 수 있는지
                visited[idx] = True
                que.append((word,step+1))
    return 0