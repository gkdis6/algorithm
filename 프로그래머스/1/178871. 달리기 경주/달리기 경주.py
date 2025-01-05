def solution(players, callings):
    player_index = {name: idx for idx, name in enumerate(players)}
    
    for name in callings:
        idx = player_index[name]
        pre = players[idx - 1]
        players[idx - 1], players[idx] = players[idx], players[idx - 1]
        player_index[name] -= 1
        player_index[pre] += 1

    return players