tot = set()
for _ in range(10):
    n = int(input())
    tot.add(n % 42)

print(len(tot))