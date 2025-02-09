def solution(picks, minerals):
    total_picks = sum(picks)
    max_mine = total_picks * 5
    minerals = minerals[:max_mine]
    
    fatigue = {
        'diamond': [1, 1, 1],
        'iron': [5, 1, 1],
        'stone': [25, 5, 1]
    }
    
    mineral_map = {'diamond': 0, 'iron': 1, 'stone': 2}
    chunks = [minerals[i:i+5] for i in range(0, len(minerals), 5)]
    
    importance = []
    for chunk in chunks:
        count = [0, 0, 0]
        for mineral in chunk:
            count[mineral_map[mineral]] += 1
        importance.append(count)
    
    importance.sort(reverse=True)
    
    total_fatigue = 0
    for count in importance:
        if picks[0] > 0:
            total_fatigue += sum(count)
            picks[0] -= 1
        elif picks[1] > 0:
            total_fatigue += count[0] * 5 + count[1] * 1 + count[2] * 1
            picks[1] -= 1
        elif picks[2] > 0:
            total_fatigue += count[0] * 25 + count[1] * 5 + count[2] * 1
            picks[2] -= 1
        else:
            break

    return total_fatigue