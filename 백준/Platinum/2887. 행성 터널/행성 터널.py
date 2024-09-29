from sys import stdin
from heapq import heappush, heappop

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])

    return parent[x]

def union(a, b):
    p1, p2 = find(a), find(b)
    parent[p1] = min(p1, p2)
    parent[p2] = min(p1, p2)


input = stdin.readline

n = int(input())

x_list = list()
y_list = list()
z_list = list()

for i in range(n):
    x, y, z = map(int, input().split())
    x_list.append((x, i))
    y_list.append((y, i))
    z_list.append((z, i))

x_list.sort()
y_list.sort()
z_list.sort()

edges = []

for cur_list in x_list, y_list, z_list:
    for i in range(1, n):
        v1, a = cur_list[i]
        v2, b = cur_list[i-1]
        heappush(edges, (abs(v1 - v2), a, b))

parent = [i for i in range(n)]
res = 0
while edges:
    cost, n1, n2 = heappop(edges)
    if find(n1) != find(n2):
        union(n1, n2)
        res += cost

print(res)