a, b, c = map(int, input().split())

def multi(x, y):
    if y == 1:
        return x % c

    half = multi(x, y // 2)
    if y % 2:
        return (half * half * x) % c
    return (half * half) % c

print(multi(a, b))