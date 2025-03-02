n = int(input())

grid = [input().split() for _ in range(n)]

def count(square, w):
    if w == 1:
        return (0, 1) if square[0][0] == '1' else (1, 0)

    one = count(list(map(lambda x: x[:w//2], square[:w//2])), w // 2)
    two = count(list(map(lambda x: x[w//2:], square[:w//2])), w // 2)
    thr = count(list(map(lambda x: x[:w//2], square[w//2:])), w // 2)
    fou = count(list(map(lambda x: x[w//2:], square[w//2:])), w // 2)

    if one[0] == two[0] == thr[0] == fou[0] == 0:
        return 0, 1
    elif one[1] == two[1] == thr[1] == fou[1] == 0:
        return 1, 0

    return one[0] + two[0] + thr[0] + fou[0], one[1] + two[1] + thr[1] + fou[1]

white, blue = count(grid, n)
print(white)
print(blue)
