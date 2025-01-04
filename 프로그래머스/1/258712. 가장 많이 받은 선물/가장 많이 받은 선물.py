def solution(friends, gifts):
    n = len(friends)
    
    arr = [[0] * n for _ in range(n)]
    gift_score = [0]*n
    
    
    for i in gifts:
        idx = i.index(' ')
        sender = i[:idx]
        receiver = i[idx+1:]
        arr[friends.index(sender)][friends.index(receiver)] += 1
        arr[friends.index(receiver)][friends.index(sender)] -= 1
        gift_score[friends.index(sender)] += 1
        gift_score[friends.index(receiver)] -= 1
    result = 0
    for idx, friend in enumerate(friends):
        score = gift_score[idx]
        gift = arr[idx]
        cur = sum([1 for i in gift if i > 0])
        cur += sum([1 for index,i in enumerate(gift) if i == 0 and score > gift_score[index]])
        result = max(result, cur)
    return result
        
        