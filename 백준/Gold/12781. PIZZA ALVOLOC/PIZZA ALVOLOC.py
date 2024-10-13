
x1, y1, x2, y2, x3, y3, x4, y4 = map(int, input().split())

def ccw(x1, y1, x2, y2, x3, y3):

    return x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3


a = ccw(x1, y1, x2, y2, x3, y3)
b = ccw(x1, y1, x2, y2, x4, y4)
if a * b < 0:
    print(1)
else:
    print(0)