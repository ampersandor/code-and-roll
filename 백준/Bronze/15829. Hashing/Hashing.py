n = int(input())
word = input()
hashed = 0
r = 31
M = 1234567891

for i, w in enumerate(word):
    hashed += (ord(w)-96) * (r ** i)

print(hashed % M)

