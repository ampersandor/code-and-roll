def onLine(x1, y1, x2, y2, x3, y3):
    return ((x2 - x1) * (y3 - y2) == (x3 - x2) * (y2 - y1)
            and min(x1, x2) <= x3 <= max(x1, x2)
            and min(y1, y2) <= y3 <= max(y1, y2))


def ccw(x1, y1, x2, y2, x3, y3):
    return x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3


def is_in_group(x1, y1,  x2, y2, x3, y3, x4, y4):
    a = ccw(x1, y1, x2, y2, x3, y3)
    b = ccw(x1, y1, x2, y2, x4, y4)
    c = ccw(x3, y3, x4, y4, x1, y1)
    d = ccw(x3, y3, x4, y4, x2, y2)
    e = (onLine(x1, y1, x2, y2, x3, y3) or
         onLine(x1, y1, x2, y2, x4, y4) or
         onLine(x3, y3, x4, y4, x1, y1) or
         onLine(x3, y3, x4, y4, x2, y2))

    return e or (a * b < 0 and c * d < 0)

n = int(input())
lines = [list(map(int, input().split())) for _ in range(n)]
parent = {i: i for i in range(n)}
sizes = {i: 1 for i in range(n)}

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    p1, p2 = find(a), find(b)
    parent[p1] = min(p1, p2)
    parent[p2] = min(p1, p2)
    sizes[min(p1, p2)] += sizes[max(p1, p2)]
    sizes[max(p1, p2)] = 0




for i in range(n):
    for j in range(n):
        if find(i) != find(j) and is_in_group(*lines[i], *lines[j]):
            union(i, j)

print(len(set(parent.values())))
print(max(sizes.values()))
