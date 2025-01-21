
cur = 0
for _ in range(3):
    num = input()
    if cur:
        cur += 1
    if num.isnumeric():
        cur = int(num)

cur += 1

if cur % 3 == 0 and cur % 5 == 0:
    print("FizzBuzz")
elif cur % 3 == 0:
    print("Fizz")
elif cur % 5 == 0:
    print("Buzz")
else:
    print(cur)
