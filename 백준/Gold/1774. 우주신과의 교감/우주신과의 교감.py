from sys import stdin
from heapq import heappush, heappop
from math import sqrt

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    p1, p2 = find(a), find(b)
    if p1 == p2:
        return False
    parent[p1] = min(p1, p2)
    parent[p2] = min(p1, p2)
    return True

def calc(x1, y1, x2, y2):
    return sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)


input = stdin.readline

n, m = map(int, input().split())
heap = []
parent = [i for i in range(n)]
dots = [tuple(map(int, input().split())) for _ in range(n)]
res = 0

for _ in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())
    union(a, b)

for i in range(n-1):
    for j in range(i+1, n):
        if find(i) != find(j):
            heappush(heap, (calc(*dots[i], *dots[j]), i, j))


while heap:
    w, a, b = heappop(heap)
    if union(a, b):
        res += w


print(f"{res:.2f}")