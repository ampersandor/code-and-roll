from sys import stdin

input = stdin.readline
n = int(input())

stack = []

for _ in range(n):
    args = input().strip().split()
    if args[0] == "push":
        stack.append(args[1])
    elif args[0] == "pop":
        print(stack.pop() if stack else -1)
    elif args[0] == "top":
        print(stack[-1] if stack else -1)
    elif args[0] == "size":
        print(len(stack))
    elif args[0] == "empty":
        print(0 if stack else 1)