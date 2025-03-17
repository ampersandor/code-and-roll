from sys import stdin
from collections import deque

input = stdin.readline
DELTA = (0, 1, 0, -1, 0)
UD = (-1, 1)


def bfs(que, todo):
    while que:
        q, x, y, c = que.popleft()
        for d in range(4):
            nx, ny = x + DELTA[d], y + DELTA[d + 1]
            if 0 <= nx < m and 0 <= ny < n and not tomatoes[q][nx][ny]:
                tomatoes[q][nx][ny] = 1
                que.append((q, nx, ny, c + 1))
                todo -= 1
        for ud in UD:
            nq = q + ud
            if 0 <= nq < h and not tomatoes[nq][x][y]:
                tomatoes[nq][x][y] = 1
                que.append((nq, x, y, c + 1))
                todo -= 1
        if todo == 0:
            return c + 1
    return -1


n, m, h = map(int, input().split())

tomatoes = [[list(map(int, input().split())) for _ in range(m)] for _ in range(h)]
que = deque([])

todo = 0
for k in range(h):
    for i in range(m):
        for j in range(n):
            if tomatoes[k][i][j] == 1:
                que.append((k, i, j, 0))
            elif tomatoes[k][i][j] == 0:
                todo += 1
if todo == 0:
    print(0)
else:
    print(bfs(que, todo))
