from sys import stdin

input = stdin.readline

n = int(input())
ages = [[] for _ in range(201)]


for i in range(n):
    age, name = input().strip().split()
    ages[int(age)].append((i, name))

for age in range(1, 201):
    if ages[age]:
        print("\n".join(map(lambda x: f"{age} {x[1]}", ages[age])))
