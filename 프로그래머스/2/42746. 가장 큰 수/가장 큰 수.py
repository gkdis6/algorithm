import functools

def solution(numbers):
    answer = ''.join(sorted([str(i) for i in numbers],
                key=functools.cmp_to_key(lambda x, y: -1 if x + y > y + x else (1 if x + y < y + x else 0))))
    
    return '0' if answer[0] == '0' else answer