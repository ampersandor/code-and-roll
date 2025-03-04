
INF = float('inf')
n, m, b = map(int, input().split())
lands = []
for _ in range(n):
    lands += list(map(int, input().split()))

min_h, max_h = min(lands), max(lands)

def calc(height):
    dig, pour = 0, 0
    for land in lands:
        if land > height:
            dig += (land - height)
        elif land < height:
            pour += (height - land)
    if pour > dig + b:
        return INF

    return dig * 2 + pour


cost = INF
res = 0

for h in range(min_h, max_h + 1):
    new_cost = calc(h)
    if new_cost <= cost:
        res = h
        cost = new_cost

print(cost, res)