def solution(cards1, cards2, goal):
    ptr1, ptr2 = 0,0
    for i in goal:
        if cards1[min(ptr1,len(cards1)-1)] == i:
            ptr1 += 1
        elif cards2[min(ptr2,len(cards2)-1)] == i:
            ptr2 += 1
        else: return "No"
    return "Yes"