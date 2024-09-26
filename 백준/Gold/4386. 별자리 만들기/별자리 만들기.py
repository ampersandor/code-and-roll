from sys import stdin
from heapq import heappush, heappop


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])

    return parent[x]


def union(a, b):
    p1, p2 = find(a), find(b)
    if p1 == p2:
        return True

    parent[p1] = min(p1, p2)
    parent[p2] = min(p1, p2)

    return False


def dist(x1, y1, x2, y2):

    return ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5


input = stdin.readline
n = int(input())
stars = [tuple(map(float, input().split())) for _ in range(n)]
parent = {i : i for i in range(n)}
edges = []

for i in range(n - 1):
    for j in range(i + 1, n):
        cost = dist(*stars[i], *stars[j])
        heappush(edges, (cost, i, j))

res = 0

while edges:
    cost, a, b = heappop(edges)
    if not union(a, b):  # if two stars are not in same group
        res += cost

print(res)