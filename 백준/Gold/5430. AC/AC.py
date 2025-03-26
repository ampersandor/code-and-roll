from sys import stdin, stdout
read = stdin.readline
write = stdout.write
T = int(read())

def compress(ops, r_idx):
    l, r = 0, r_idx
    rev = False
    for op in ops:
        if op == "R":
            rev ^= True
        elif rev:
            r -= 1
        else:
            l += 1

    return l, r, rev

def express(arr, l, r, rev):
    if rev:
        for i in range(r-1, l-1, -1):
            yield str(arr[i])
    else:
        for i in range(l, r):
            yield str(arr[i])


for _ in range(T):
    p = read().strip()
    n = int(read())
    arr = eval(read().strip())
    l, r, rev = compress(p, n)
    if l > r:
        write("error\n")
    else:
        write(f"[{','.join(express(arr, l, r, rev))}]\n")
 