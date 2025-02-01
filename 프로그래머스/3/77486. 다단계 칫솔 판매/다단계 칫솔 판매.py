def solution(enroll, referral, seller, amount):
    amounts = {who:0 for who in enroll}
    parent = dict(zip(enroll,referral))
    parent['-'] = ''
    amounts['-'] = 0
    for who, income in zip(seller,amount):
        income = income*100
        while who != '':
            if income < 10:
                amounts[who] += income
                break
            amounts[who] += (income - income//10)
            income = income//10
            who = parent[who]
            
    answer = [amounts[i] for i in enroll]
    return answer