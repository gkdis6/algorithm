import sys

n = int(sys.stdin.readline())
result = 0
for _ in range(n):
    stack = []
    line = sys.stdin.readline().strip()
    if len(line) %2 == 1:
        continue
    for word in line:
        if not stack or stack[-1] != word:
            stack.append(word)
        elif stack[-1] == word:
            stack.pop()
    if not stack:
        result += 1

print(result)