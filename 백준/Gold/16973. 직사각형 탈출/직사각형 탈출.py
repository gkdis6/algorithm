import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

arr = [[0] * (M + 1)]
arr += [[0] + list(map(int,input().rstrip().split())) for _ in range(N)]

H, W, Sr, Sc, Fr, Fc = map(int, input().split())

p_sum = [[0] * (M+1) for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, M+1):
        p_sum[i][j] = arr[i][j] + p_sum[i-1][j] + p_sum[i][j-1] - p_sum[i-1][j-1]

def can_place(i,j):
    if i < 1 or j < 1 or i+H-1 > N or j+W-1 > M:
        return False
    total = p_sum[i+H-1][j+W-1] - p_sum[i-1][j+W-1] - p_sum[i+H-1][j-1] + p_sum[i-1][j-1]
    return total == 0

visited = [[False] * (M+1) for _ in range(N+1)]
q = deque()

visited[Sr][Sc] = True
q.append((Sr,Sc,0))

answer = -1
dirs = [(0,1), (0,-1), (1,0), (-1,0)]

while q:
    r,c,depth = q.popleft()

    if r == Fr and c == Fc:
        answer = depth
        break

    for dr,dc in dirs:
        nr, nc = r + dr, c + dc
        if can_place(nr,nc) and not visited[nr][nc]:
            visited[nr][nc] = True
            q.append((nr,nc, depth+1))

print(answer)
