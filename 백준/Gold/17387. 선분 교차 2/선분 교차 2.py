x1, y1, x2, y2 = map(int, input().split())

x3, y3, x4, y4 = map(int, input().split())

"""
(x2 - x1) = (x3 - x2)
(y2 - y1) = (y3 - y2)
"""
def onLine(x1, y1, x2, y2, x3, y3):

    return ((x2 - x1) * (y3 - y2) == (x3 - x2) * (y2 - y1) and min(x1, x2) <= x3 <= max(x1, x2)
            and min(y1, y2) <= y3 <= max(y1, y2))

def ccw(x1, y1, x2, y2, x3, y3):

    return x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3


a = ccw(x1, y1, x2, y2, x3, y3)
b = ccw(x1, y1, x2, y2, x4, y4)

c = ccw(x3, y3, x4, y4, x1, y1)
d = ccw(x3, y3, x4, y4, x2, y2)

e = onLine(x1, y1, x2, y2, x3, y3) or onLine(x1, y1, x2, y2, x4, y4) or onLine(x3, y3, x4, y4, x1, y1) or onLine(x3, y3, x4, y4, x2, y2)


if e or (a * b < 0 and c * d < 0):
    print("1")
else:
    print("0")