def solution(data, ext, val_ext, sort_by):
    code = ['code','date','maximum','remain']
    ext = code.index(ext)
    sort_by = code.index(sort_by)
    
    return sorted([dat for dat in data if dat[ext]<=val_ext], key=lambda x: x[sort_by])