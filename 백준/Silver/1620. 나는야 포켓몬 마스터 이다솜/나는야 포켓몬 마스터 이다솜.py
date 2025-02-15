from sys import stdin, stdout

read = stdin.readline
write = stdout.write

n, m = map(int, read().strip().split())

monsters = []
indices = [dict() for _ in range(21)]


for i in range(1, n+1):
    monsters.append(monster:=read().strip())
    indices[len(monster)][monster] = str(i)

for _ in range(m):
    query = read().strip()
    if query.isnumeric():
        write(monsters[int(query)-1] + "\n")
    else:
        write(indices[len(query)][query] + "\n")