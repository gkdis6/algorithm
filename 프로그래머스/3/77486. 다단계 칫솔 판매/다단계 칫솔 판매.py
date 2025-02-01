def solution(enroll, referral, seller, amount):
    parent = dict(zip(enroll,referral))
    amounts = {who:0 for who in enroll}
    
    for who, income in zip(seller,amount):
        income = income*100
        while income > 0 and who != '-':
            amounts[who] += income - income//10
            who = parent[who]
            income //= 10
            
    return [amounts[i] for i in enroll]