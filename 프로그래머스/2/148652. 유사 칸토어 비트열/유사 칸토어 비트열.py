def solution(n, l, r):
    l -= 1  
    
    def countOnes(n, l, r):
        if n == 0:
            return 1 if l < 1 and r > 0 else 0
        
        segLen = 5 ** (n - 1)
        total = 0
        for i in range(5):
            segStart = i * segLen
            segEnd = segStart + segLen
            if r <= segStart or l >= segEnd:
                continue
            newL = max(l - segStart, 0)
            newR = min(r - segStart, segLen)
            if i == 2:
                continue
            else:
                total += countOnes(n - 1, newL, newR)
        return total
    
    return countOnes(n, l, r)