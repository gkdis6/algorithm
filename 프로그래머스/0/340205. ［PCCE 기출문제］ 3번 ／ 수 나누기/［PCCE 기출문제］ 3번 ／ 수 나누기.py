number = int(input())

answer = 0

for i in range(6):
    answer += number % 100
    number //= 100

print(answer)