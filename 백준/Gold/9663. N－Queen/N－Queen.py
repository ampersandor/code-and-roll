n = int(input())

cols = [False] * n
diag_1 = [False] * (2 * n - 1)
diag_2 = [False] * (2 * n - 1)

res = [0]

def backtracking(r):
    if r == n:
        res[0] += 1
        return
    for c in range(n):
        if not (cols[c] or diag_1[r + c] or diag_2[r - c]):
            cols[c] = diag_1[r + c] = diag_2[r - c] = True
            backtracking(r + 1)
            cols[c] = diag_1[r + c] = diag_2[r - c] = False


backtracking(0)
print(res[0])
