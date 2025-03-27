import sys

while True:
    line = sys.stdin.readline().rstrip('\n')
    if line == '.':
        break

    stack = []
    balanced = True
    for word in line:
        if word == '(' or word == '[':
            stack.append(word)
        elif word == ')':
            if not stack or stack[-1] != '(':
                balanced = False
                break;
            else:
                stack.pop()
        elif word == ']':
            if not stack or stack[-1] != '[':
                balanced = False
                break;
            else:
                stack.pop()
    if balanced and not stack:
        print('yes')
    else:
        print('no')
