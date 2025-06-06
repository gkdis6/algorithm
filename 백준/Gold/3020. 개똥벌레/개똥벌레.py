import sys
input = sys.stdin.readline

N, H = map(int, input().split())

diff = [0] * (H + 1)

for i in range(N):
    height = int(input().rstrip())
    if i % 2 == 0:
        diff[0] += 1
        if height < H:
            diff[height] -= 1
    else:
        diff[H - height] += 1
        diff[H] -= 1

obstacle_count = [0] * H
obstacle_count[0] = diff[0]

min_obstacles = obstacle_count[0]
min_count = 1

for i in range(1, H):
    obstacle_count[i] = obstacle_count[i-1] + diff[i]

    if obstacle_count[i] < min_obstacles:
        min_obstacles = obstacle_count[i]
        min_count = 1
    elif obstacle_count[i] == min_obstacles:
        min_count += 1

print(min_obstacles, min_count)