n, m = map(int, input().split())

tot = (24 + n) * 60 + m - 45

print(tot // 60 % 24, tot % 60)