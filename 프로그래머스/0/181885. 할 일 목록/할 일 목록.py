def solution(todo_list, finished):
    return [todo for todo, is_finish in zip(todo_list, finished) if not is_finish ]