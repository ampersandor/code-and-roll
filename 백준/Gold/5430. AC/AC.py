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

def my_print(l, r, rev, arr):
    if l > r:
        write("error\n")
    else:
        write(f"[{','.join(map(str, arr[l:r][::-1] if rev else arr[l:r]))}]\n")


for _ in range(T):
    p = read().strip()
    n = int(read())
    arr = eval(read().strip())
    l, r, rev = compress(p, n)
    my_print(l, r, rev, arr)


