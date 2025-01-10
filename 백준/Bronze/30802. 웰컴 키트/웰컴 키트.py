n = int(input())
shirts = list(map(int, input().split()))
t, p = map(int, input().split())
a = 0
for shirt in shirts:
    a += (shirt - 1) // t + 1

print(a)
print(n // p, n % p)