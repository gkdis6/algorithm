def solution(wallet, bill):
    
    a, b = max(bill), min(bill)
    result = 0
    while max(wallet) < a or min(wallet) < b:
        a, b = max(a//2, b), min(a//2, b)
        result += 1
    return result