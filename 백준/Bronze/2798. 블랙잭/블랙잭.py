from itertools import combinations
n, m = map(int, input().split())
cards = list(map(int, input().split()))
max_diff = float('inf')
res = 0

for c1, c2, c3 in combinations(cards, 3):
    score = c1 + c2 + c3
    diff = m - score
    if diff < 0 or max_diff <= diff:
        continue
    res = score
    max_diff = diff
    if diff == 0:
        break

print(res)
