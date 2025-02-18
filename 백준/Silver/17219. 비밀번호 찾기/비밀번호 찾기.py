from sys import stdin, stdout

read = stdin.readline
write = stdout.write
n, m = map(int, input().strip().split())

cache = dict()

for _ in range(n):
    domain, pwd = input().strip().split()
    cache[domain] = pwd


for _ in range(m):
    domain = input().strip()
    write(cache[domain] + "\n")