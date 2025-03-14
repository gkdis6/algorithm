import math

def solution(arr):
    lcm = arr[0]
    for num in arr[1:]:
        lcm = (lcm * num) // math.gcd(lcm, num)
    return lcm