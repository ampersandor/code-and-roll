t = int(input())

for _ in range(t):
    n, word = input().split()
    n = int(n)
    for w in word:
        print(w * n, end="")
    print()