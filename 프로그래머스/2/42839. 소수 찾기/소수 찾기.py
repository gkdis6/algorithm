from itertools import permutations

def is_prime(number):
    if number < 2:
        return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0:
            return False
    return True

def solution(numbers):
    unique_numbers = set()
    
    for i in range(1, len(numbers) + 1):
        perms = permutations(numbers, i)
        print(str(perms))
        for perm in perms:
            num = int(''.join(perm))
            unique_numbers.add(num)
    
    prime_count = sum(1 for number in unique_numbers if is_prime(number))
    return prime_count