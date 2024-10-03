n = int(input())
arr = list(map(int, input().split()))

MIN, MAX = float('inf'), float('-inf')

for num in arr:
    MIN = min(MIN, num)
    MAX = max(MAX, num)

print(MIN, MAX)