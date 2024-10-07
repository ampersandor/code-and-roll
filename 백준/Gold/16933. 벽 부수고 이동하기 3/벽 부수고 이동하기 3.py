from sys import stdin
from collections import deque


input = stdin.readline
n, m, k = map(int, input().split())
delta = (0, 1, 0, -1, 0)
INF = float('inf')
grid = [list(input().strip()) for _ in range(n)]
visited = [[[INF for ___ in range(k+1)] for __ in range(m)] for _ in range(n)]
visited[0][0][0] = 1


que = deque([(0, 0, 1, 0, 1)]) # x, y, c, b, day
while que:
    x, y, c, b, day = que.popleft()

    for d in range(4):
        nx, ny = x + delta[d], y + delta[d+1]
        if 0 <= nx < n and 0 <= ny < m:
            if grid[nx][ny] == "1" and b < k and visited[nx][ny][b+1] == INF:
                if day == 1:
                    que.append((nx, ny, c + 1, b + 1, day * -1))
                    visited[nx][ny][b+1] = c + 1
                else:
                    que.append((x, y, c + 1, b, day * -1))
            elif grid[nx][ny] == "0" and visited[nx][ny][b] == INF:
                que.append((nx, ny, c + 1, b, day * -1))
                visited[nx][ny][b] = c + 1

res = min(visited[-1][-1])

print(res if res != float('inf') else -1)