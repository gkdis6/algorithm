def solution(sequence, k):
    n = len(sequence)
    left, right = 0, 0
    current_sum = sequence[0]
    answer = (float('inf'), 0, 0)

    while right < n:
        if current_sum == k:
            if right - left < answer[0]:
                answer = (right - left, left, right)
            elif right - left == answer[0]:
                answer = min(answer, (right - left, left, right))

            current_sum -= sequence[left]
            left += 1
        elif current_sum < k:
            right += 1
            if right < n:
                current_sum += sequence[right]
        else:
            current_sum -= sequence[left]
            left += 1

    return [answer[1], answer[2]]