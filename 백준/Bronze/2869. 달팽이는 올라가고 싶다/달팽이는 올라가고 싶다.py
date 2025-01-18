a, b, v = map(int, input().split())

low, high = 1, 1_000_000_001

def calc(x):
    return a * x - b * (x-1) >= v

ans = 0

while low < high:
    mid = low + (high - low) // 2
    if calc(mid):
        high = mid
        ans = mid
    else:
        low = mid + 1

print(ans)

