from collections import defaultdict, deque

n, m = map(int, input().split())

graph = defaultdict(set)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

def bfs(node, visited):
    res = 0
    que = deque([(node, 0)])
    while que:
        x, c = que.popleft()
        res += c
        for child in graph[x]:
            if not visited[child]:
                que.append((child, c + 1))
                visited[child] = True

    return res

ans = 0
min_score = float("inf")
for i in range(1, n+1):
    visited = [False] * (n + 1)
    visited[i] = True
    score = bfs(i, visited)

    if score < min_score:
        ans = i
        min_score = score

print(ans)