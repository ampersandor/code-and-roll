def func(a, b):
    return (a + b) * (a - b)

x, y = map(int, input().split())

print(func(x, y))