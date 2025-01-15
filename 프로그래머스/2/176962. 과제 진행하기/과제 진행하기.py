def solution(plans):
    def to_minutes(t):
        h, m = map(int, t.split(":"))
        return h * 60 + m

    tasks = []
    for subject, start, duration in plans:
        tasks.append((subject, to_minutes(start), int(duration)))
    
    tasks.sort(key=lambda x: x[1])
    
    answer = []
    stack = []
    
    for i in range(len(tasks)):
        subject, start_time, duration = tasks[i]
        
        if i < len(tasks) - 1:
            next_start = tasks[i + 1][1]  
        else:
            next_start = start_time+duration
        
        stack.append((subject, duration))
        
        current_time = start_time
        while stack:
            top_subject, top_duration = stack.pop()
            time_gap = next_start - current_time
            
            if top_duration <= time_gap:
                current_time += top_duration
                answer.append(top_subject)
            else:
                stack.append((top_subject, top_duration - time_gap))
                current_time += time_gap
                break
    
    while stack:
        subject, duration = stack.pop()
        answer.append(subject)
    
    return answer