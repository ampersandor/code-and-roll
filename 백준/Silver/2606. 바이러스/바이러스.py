from collections import defaultdict, deque

n = int(input())
m = int(input())
graph = defaultdict(set)
visited = [False] * (n + 1)
visited[1] = True
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

que = deque([1])
count = 0
while que:
    node = que.popleft()
    for child in graph[node]:
        if not visited[child]:
            que.append(child)
            visited[child] = True
            count += 1

print(count)