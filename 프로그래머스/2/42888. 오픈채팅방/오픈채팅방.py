def solution(record):
    answer = []
    uid = {}
    
    for i in record:
        cmd = i.split(" ")
        if cmd[0] != "Leave":
            uid[cmd[1]] = cmd[2]
    
    for i in record:
        cmd = i.split(" ")
        if cmd[0] == "Enter":
            answer.append("%s님이 들어왔습니다."% uid[cmd[1]])
        elif cmd[0] == "Leave":
            answer.append("%s님이 나갔습니다."% uid[cmd[1]])
    
    return answer