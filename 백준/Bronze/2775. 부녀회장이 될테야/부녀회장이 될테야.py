T = int(input())

for _ in range(T):
    k = int(input())
    t = int(input())
    nums = [x for x in range(1, t + 1)]
    for f in range(k):
        for i in range(1, t):
            nums[i] += nums[i-1]
    print(nums[-1])

"""


1 5 15
1 4 10
1 3 6
1 2 3
"""