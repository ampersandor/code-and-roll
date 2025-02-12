k, n = map(int, input().split())
wires = [int(input()) for _ in range(k)]

def expect(length):
    count = 0
    for wire in wires:
        count += wire // length
    return count

low, high = 0, 2**31

ans = -1

while low <= high:
    mid = low + (high - low + 1) // 2
    if expect(mid) < n:
        high = mid - 1
    else:
        low = mid + 1
        ans = mid

print(ans)

