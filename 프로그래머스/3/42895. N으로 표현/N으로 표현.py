answer = -1
end = 0

def DFS(n, pos, num):
    global answer, end
    if pos > 8:
        return
    if num == end:
        if pos < answer or answer == -1:
            answer=pos
        return

    nn=0
    for i in range(1,9):
        nn=nn*10+n
        DFS(n, pos+i, num+nn)
        DFS(n, pos+i, num-nn)
        DFS(n, pos+i, num*nn)
        DFS(n, pos+i, num/nn)

def solution(N, number):
    global end
    end = number
    DFS(N, 0, 0)
    return answer