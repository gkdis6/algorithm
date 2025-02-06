def solution(n, words):
    list = []
    pre = words[0][0]
    for index, word in enumerate(words, start=0):
        if word in list or pre[-1] != word[0]:
            return [index%n+1, index//n+1]
        list.append(word)
        pre = word

    return [0,0]