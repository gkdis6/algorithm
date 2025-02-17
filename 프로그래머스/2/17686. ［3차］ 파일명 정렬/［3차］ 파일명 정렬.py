import re

def solution(files):
    
    def parse(file):
        # parsing(head, number, tail)
        match = re.match(r"([^0-9]+)([0-9]+)(.*)", file)
        if match:
            head, number, tail = match.groups()
            # sort(HEAD, NUMBER(int변환))
            return head.lower(), int(number)
        return file.lower(), 0

    # 리스트 변환
    return sorted(files, key=parse)