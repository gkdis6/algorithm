def solution(video_len, pos, op_start, op_end, commands):
    def time_to_seconds(time_str):
        minutes, seconds = map(int, time_str.split(':'))
        return minutes * 60 + seconds

    def seconds_to_time(seconds):
        minutes = seconds // 60
        seconds = seconds % 60
        return f'{minutes:02}:{seconds:02}'

    video_length = time_to_seconds(video_len)
    current_pos = time_to_seconds(pos)
    opening_start = time_to_seconds(op_start)
    opening_end = time_to_seconds(op_end)

    if opening_start <= current_pos <= opening_end:
        current_pos = opening_end

    for command in commands:
        if command == "prev":
            current_pos = max(current_pos - 10, 0)
        elif command == "next":
            current_pos = min(current_pos + 10, video_length)
        
        if opening_start <= current_pos <= opening_end:
            current_pos = opening_end

    return seconds_to_time(current_pos)