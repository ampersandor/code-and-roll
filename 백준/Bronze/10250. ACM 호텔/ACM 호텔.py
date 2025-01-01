t = int(input())

for _ in range(t):
    h, w, n = map(int, input().split())

    floor = (n - 1) % h + 1
    room = (n - 1) // h + 1

    print(f"{floor}{str(room).zfill(2)}")