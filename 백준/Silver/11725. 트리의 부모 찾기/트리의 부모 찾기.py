from sys import stdin, stdout
from collections import defaultdict, deque

read = stdin.readline
write = stdout.write

n = int(read())
graph = defaultdict(list)
for _ in range(n-1):
    a, b = map(int, read().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (n+1)
visited[1] = 1
que = deque([1])

while que:
    node = que.popleft()
    for child in graph[node]:
        if not visited[child]:
            visited[child] = node
            que.append(child)

write("\n".join(map(str, visited[2:])))