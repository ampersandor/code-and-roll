import sys 
input = sys.stdin.readline 

m = int(input()) 
arr = list(map(int, input().split())) 

k = (5 * (10 ** 5)).bit_length()

sparse = [[0] * (m + 1) for _ in range(k)] 
# sparse[i][j] = f에 "j를 2 ** i번 대입한 값" 

for i in range(1, m + 1): 
    sparse[0][i] = arr[i - 1] 

for i in range(1, k): 
    for j in range(1, m + 1):
        sparse[i][j] = sparse[i - 1][sparse[i - 1][j]] 

Q = int(input()) 
for _ in range(Q): 
    n, x = map(int, input().split(' ')) 

    i = k - 1 
    while n: 
        while 2 ** i > n: 
            i -= 1 
        x = sparse[i][x] 
        n -= 2 ** i 
    print(x) 