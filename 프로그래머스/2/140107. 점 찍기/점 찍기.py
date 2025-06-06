import math

def solution(k, d):
    d /= k
    count = 0
    for x in range(0, int(d + 1)):
        y_max = int(math.sqrt(d*d - x*x))
        count += (y_max + 1)
    return count