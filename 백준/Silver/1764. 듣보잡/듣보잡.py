from sys import stdin, stdout

read = stdin.readline
write = stdout.write

n, m = map(int, read().strip().split())

names = [set() for _ in range(21)]

res = []

for _ in range(n):
    n1 = read().strip()
    names[len(n1)].add(n1)

for _ in range(m):
    n2 = read().strip()
    if n2 in names[len(n2)]:
        res.append(n2)

write(str(len(res)) + "\n")
write("\n".join(sorted(res)))

