from sys import stdin

input = stdin.readline

n = int(input())
stack = []
for _ in range(n):
    num = int(input())
    if num:
        stack.append(num)
    else:
        stack.pop()

print(sum(stack))