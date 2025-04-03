from itertools import combinations

INF = 1e9

n, m = map(int, input().split())

def dist(a, b, c, d):
    return abs(a - c) + abs(b - d)

houses = []
stores = []
for i in range(n):
    row = input().strip().split()
    for j in range(n):
        if row[j] == "1":
            houses.append((i, j))
        elif row[j] == "2":
            stores.append((i, j))

house_to_store = [[0] * len(stores) for _ in range(len(houses))]
for i in range(len(houses)):
    for j in range(len(stores)):
        x = dist(*houses[i], *stores[j])
        house_to_store[i][j] = x

res = INF
for comb in combinations(range(len(stores)), min(m, len(stores))):
    min_costs = 0
    for i in range(len(house_to_store)):
        min_costs += min([house_to_store[i][j] for j in comb])
    res = min(res, min_costs)

print(res)