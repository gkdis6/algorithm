def solution(sizes):
    return max(max(x, y) for x, y in sizes) * max(min(x, y) for x, y in sizes)