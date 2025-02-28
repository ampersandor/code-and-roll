formula = input()

res = 0
num = 0
tmp = 0
stack = []

for char in formula:
    if char.isnumeric():
        num = num * 10 + int(char)
    else:
        if stack and stack[-1] == "+":
            stack.pop()
            stack[-1] += num
        else:
            stack.append(num)
        stack.append(char)
        num = 0

if stack and stack[-1] == "+":
    stack.pop()
    stack[-1] += num
else:
    stack.append(num)

res = stack[0]
for num in stack[1:]:
    if type(num) == int:
        res -= num

print(res)
