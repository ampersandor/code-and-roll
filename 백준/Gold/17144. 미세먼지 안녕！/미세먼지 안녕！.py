r, c, t = map(int, input().split())

grid = []
robot = []
DELTA = (0, 1, 0, -1, 0)
for i in range(r):
    row = list(map(int, input().split()))
    for j in range(c):
        if row[j] == -1:
            robot.append((i, j))
    grid.append(row)


def spread():
    global grid
    new_grid = [[0] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if grid[i][j] > 0:
                cur = grid[i][j]
                for d in range(4):
                    ni, nj = i + DELTA[d], j + DELTA[d+1]
                    if 0 <= ni < r and 0 <= nj < c and grid[ni][nj] != -1:
                        new_grid[ni][nj] += grid[i][j] // 5
                        cur -= grid[i][j] // 5
                new_grid[i][j] += cur
            elif grid[i][j] == -1:
                new_grid[i][j] = grid[i][j]
    grid = new_grid[::]
    del new_grid

def blow(x, y, clockwise):
    if clockwise:
        rotate = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    else:
        rotate = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    d = 0
    a, b = x, y
    nx, ny = x + rotate[d][0], y + rotate[d][1]
    if not (0 <= nx < r and 0 <= ny < c) or (not clockwise and not (0 <= nx <= a)) or (clockwise and not (a <= nx < r)):
        d = (d + 1) % 4
        nx, ny = x + rotate[d][0], y + rotate[d][1]

    while nx != a or ny != b:
        grid[x][y] = grid[nx][ny]
        x, y = nx, ny
        nx, ny = x + rotate[d][0], y + rotate[d][1]
        if not (0 <= nx < r and 0 <= ny < c) or (not clockwise and not (0 <= nx <= a)) or (
                clockwise and not (a <= nx < r)):
            d = (d + 1) % 4
            nx, ny = x + rotate[d][0], y + rotate[d][1]
    grid[x][y] = 0
    grid[a][b] = -1



for _ in range(t):
    spread()
    blow(*robot[0], clockwise=False)
    blow(*robot[1], clockwise=True)

res = 0
for i in range(r):
    for j in range(c):
        if grid[i][j] > 0:
            res += grid[i][j]

print(res)