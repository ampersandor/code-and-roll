n, m = map(int, input().split())

monsters = []
indices = dict()

for i in range(1, n+1):
    monsters.append(monster:=input())
    indices[monster] = i

for _ in range(m):
    query = input()
    if query.isnumeric():
        print(monsters[int(query)-1])
    else:
        print(indices[query])