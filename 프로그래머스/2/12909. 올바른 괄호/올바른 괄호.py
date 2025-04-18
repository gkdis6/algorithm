def solution(s):
    list = {"left":0, "right":0}
    for item in s:
        if item == "(":
            list["left"] += 1
        else:
            if list["right"] + 1 > list["left"]:
                return False
            else:
                list["right"] += 1
    return list["left"] == list["right"]
