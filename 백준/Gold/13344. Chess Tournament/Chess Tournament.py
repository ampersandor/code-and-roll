from collections import defaultdict, deque
from sys import stdin


input = stdin.readline
n, m = map(int, input().split())

parents = {i: i for i in range(n)}

def get_parent(x):
    if x == parents[x]:
        return x
    parents[x] = get_parent(parents[x])
    return parents[x]

def union(a, b):
    p1, p2 = get_parent(a), get_parent(b)
    parents[p1] = min(p1, p2)
    parents[p2] = min(p1, p2)


info = []
for _ in range(m):
    a, s, b = input().split()
    a, b = int(a), int(b)
    if s == "=":
        union(a, b)
    else:
        info.append((a, b))

in_degree = [0] * n
graph = defaultdict(list)
que = deque()

for a, b in info:
    a, b = get_parent(a), get_parent(b)
    graph[a].append(b)
    in_degree[b] += 1

count = 0
true_nodes = set(parents.values())
num_nodes= len(true_nodes)

for node in true_nodes:
    if in_degree[node] == 0:
        que.append(node)

while que:
    node = que.popleft()
    if in_degree[node]:
        continue
    count += 1
    for child in graph[node]:
        in_degree[child] -= 1
        if in_degree[child] == 0:
            que.append(child)

print("consistent" if count == num_nodes else "inconsistent")


