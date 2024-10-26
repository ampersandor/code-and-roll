from sys import stdin
from collections import deque


input = stdin.readline

n, m, k = map(int, input().split())
INF = float('inf')
grid = [input().strip() for _ in range(n)]

visited = [[[INF] * (k+1) for _ in range(m)] for _ in range(n)]
delta = (0, 1, 0, -1, 0)
que = deque([(0, 0, 0, 1)]) # x, y, k, cost
visited[0][0][0] = 1

while que:
    x, y, i, cost = que.popleft()
    for d in range(4):
        nx, ny = x + delta[d], y + delta[d+1]
        if 0 <= nx < n and 0 <= ny < m:
            if grid[nx][ny] == "1" and i < k and cost + 1 < visited[nx][ny][i+1]: # wall
                visited[nx][ny][i+1] = cost + 1
                que.append((nx, ny, i + 1, cost + 1))
            elif grid[nx][ny] == "0" and cost + 1 < visited[nx][ny][i]: # hall
                visited[nx][ny][i] = cost + 1
                que.append((nx, ny, i, cost + 1))


res = min(visited[-1][-1])

print(res if res != INF else -1)



