n, k = map(int, input().split())

res = 1
div = 1
for i in range(k):
    res *= (n-i)
    div *= (k-i)

print(res // div)
