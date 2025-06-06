import sys

T = int(sys.stdin.readline().strip())
for _ in range(T):
    data = list(map(int, input().split()))
    tc = data[0]
    arr = data[1:]
    moves = 0
    
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                moves += 1
                
    print(tc, moves)