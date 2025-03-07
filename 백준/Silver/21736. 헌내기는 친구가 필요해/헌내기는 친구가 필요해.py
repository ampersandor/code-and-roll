from collections import deque

n, m = map(int, input().split())
grid = []
start: tuple = (0, 0)
for i in range(n):
    row = input().strip()
    for j, char in enumerate(row):
        if char == "I":
            start = i, j
    grid.append(row)

visited = [[False] * m for _ in range(n)]

que = deque([start])
visited[start[0]][start[1]] = True
delta = (0, 1, 0, -1, 0)
res = 0
while que:
    x, y = que.popleft()
    if grid[x][y] == "P":
        res += 1

    for d in range(4):
        nx, ny = x + delta[d], y + delta[d+1]
        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and grid[nx][ny] != "X":
            visited[nx][ny] = True
            que.append((nx, ny))

print(res if res else "TT")