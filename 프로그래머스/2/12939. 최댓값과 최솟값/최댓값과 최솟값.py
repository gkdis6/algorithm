def solution(s):
    numbers = list(map(int, s.split()))

    return f"{min(numbers)} {max(numbers)}"