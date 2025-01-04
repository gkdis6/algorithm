def solution(bandage, health, attacks):
    def heal(cur_health, time):
        duration,per_regen,plus_regen = bandage
        return min(health, cur_health+time*per_regen+(time//duration*plus_regen))
    
    attacks.sort(key=lambda x: x[0])
    cur_health = health
    cur_time = 0
    for attack in attacks:
        time, damage = attack
        cur_health = heal(cur_health, time-cur_time)
        cur_time = time+1
        cur_health -= damage
        if cur_health <= 0: return -1

    return cur_health
        