def sum_of_digits(num):
    res = 0
    while num > 0:
        res += num % 10
        num //= 10
    return res

def num_of_digits(num):
    count = 0
    while num > 0:
        count += 1
        num //= 10
    return count

def solve(num):
    for i in range(num_of_digits(num) * 9, 0, -1):
        m = num - i
        if sum_of_digits(m) + m == num:
            return m
    return 0


n = int(input())

print(solve(n))