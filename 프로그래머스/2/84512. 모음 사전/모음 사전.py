from itertools import permutations

def solution(word):
    words = 'AEIOU'*5
    unique_words = set()
    
    for i in range(1, 6):
        perms = permutations(words, i)

        for perm in perms:
            new_word = (''.join(perm))
            unique_words.add(new_word)
    # print(sorted(list(unique_words)))
    return sorted(list(unique_words)).index(word)+1
    