def solution(wallpaper):
    first = len(wallpaper)+1
    second = len(wallpaper[0])+1
    third = -1
    forth = -1
    for y, line in enumerate(wallpaper):
        for x, i in enumerate(line):
            if i == '#':
                first = min(first, y)
                second = min(second, x)
                third = max(third, y+1)
                forth = max(forth, x+1)
    return [first, second, third, forth]