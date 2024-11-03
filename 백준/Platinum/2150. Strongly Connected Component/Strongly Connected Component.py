from sys import stdin, setrecursionlimit
from collections import defaultdict

def tarjan(node):
    global _id
    _id += 1
    id_of[node] = _id
    stack.append(node)
    on_stack[node] = True

    parent = id_of[node]
    for child in graph[node]:
        if not id_of[child]:
            parent = min(parent, tarjan(child))
        elif on_stack[child]:
            parent = min(parent, id_of[child])

    if parent == id_of[node]:
        scc = []
        while True:
            cur = stack.pop()
            on_stack[cur] = False
            scc.append(cur)
            if cur == node:
                break
        res.append(sorted(scc))
    return parent


setrecursionlimit(10**5)
input = stdin.readline

res = []
v, e = map(int, input().split())
graph = defaultdict(list)

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)

stack = []
id_of = [0 for _ in range(v + 1)]
on_stack = [False] * (v + 1)
_id = 0
for node in range(1, v + 1):
    if not id_of[node]:
        tarjan(node)

print(len(res))

for row in sorted(res):
    print(*row, -1)