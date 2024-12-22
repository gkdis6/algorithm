from collections import defaultdict

def solution(genres, plays):
    genre_to_songs = defaultdict(list)
    genre_to_total = defaultdict(int)
    
    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_to_songs[genre].append((play, i))
        genre_to_total[genre] += play
    
    sorted_genres = sorted(genre_to_total.keys(), key=lambda g: genre_to_total[g], reverse=True)
    
    result = []
    for genre in sorted_genres:
        songs = sorted(genre_to_songs[genre], key=lambda x: -x[0])
        result.extend([song[1] for song in songs[:2]])
    
    return result