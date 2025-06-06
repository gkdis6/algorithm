import sys

line = sys.stdin.readline()
result = 0
stack = []
for i in range(len(line)):
    word = line[i]
    if word == '(':
        stack.append(len(stack))
    elif word == ')':
        cur = stack.pop()
        if line[i-1] == '(':
            result += cur
        else:
            result += 1

print(result)