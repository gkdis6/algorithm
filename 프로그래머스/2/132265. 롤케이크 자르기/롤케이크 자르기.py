import collections

def solution(topping):
    answer = 0
    
    counter = collections.Counter(topping)

    arr=set()
    for i in topping:
        arr.add(i)
        counter[i] -=1
        if counter[i] == 0:
            counter.pop(i)
        if len(arr) == len(counter):
            answer +=1
    return answer