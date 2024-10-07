from sys import stdin
from collections import deque

input = stdin.readline
INF = float('inf')
delta = (0, 1, 0, -1, 0)

n, m, k = map(int, input().split())
board = [input().strip() for _ in range(n)]
visited = [[INF for _ in range(m)] for _ in range(n)]
visited[0][0] = 0

count = 1

que = deque([(0, 0, 0, 1, True)])  # x, y, break


while que:
    x, y, b, c, day = que.popleft()
    if x == n - 1 and y == m - 1:
        print(c)
        exit(0)
    for d in range(4):
        nx, ny = x + delta[d], y + delta[d+1]
        if 0 <= nx < n and 0 <= ny < m and b < visited[nx][ny]:
            if board[nx][ny] == '0':
                que.append((nx, ny, b, c + 1, not day))
                visited[nx][ny] = b
            elif b < k:
                if not day:
                    que.append((x, y, b, c + 1, not day))
                else:
                    visited[nx][ny] = b
                    que.append((nx, ny, b + 1, c + 1, not day))

print(-1)
