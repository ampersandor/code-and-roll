import sys

n, m = map(int, input().split())

grid = [list(input().strip()) for _ in range(n)]
visited = [0] * 26
visited[ord(grid[0][0]) - ord('A')] = 1
DELTA = (0, 1, 0, -1, 0)
res = 0


def find(i, j, count):
    global res
    res = max(res, count)
    if res == 26:
        print(res)
        sys.exit(0)
    for d in range(4):
        ni, nj = i + DELTA[d], j + DELTA[d+1]
        if 0 <= ni < n and 0 <= nj < m and not visited[ord(grid[ni][nj]) - ord('A')]:
            visited[ord(grid[ni][nj]) - ord('A')] = 1
            find(ni, nj, count + 1)
            visited[(ord(grid[ni][nj]) - ord('A'))] = 0
find(0, 0, 1)
print(res)

# {'H', 'G', 'D', 'A', 'F', 'B', 'J'}
# 3 6
# HFDFFB
# AJHGDH
# DGAGEH
#
# HFJADG