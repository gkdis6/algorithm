import sys

n = int(sys.stdin.readline())
stack = []

for _ in range(n):
    line = sys.stdin.readline().strip()
    parts = line.split()
    command = parts[0]
    
    if command == '1':
        num = parts[1]
        stack.append(num)
    
    elif command == '2':
        if stack:
            print(stack.pop())
        else:
            print('-1')
    
    elif command == '3':
        print(len(stack))
    
    elif command == '4':
        print(1 if not stack else 0)
    
    elif command == '5':
        print(stack[-1] if stack else '-1')