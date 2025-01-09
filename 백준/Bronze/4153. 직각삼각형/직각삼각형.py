nums = sorted(map(int, input().split()))

while nums != [0, 0, 0]:
    if nums[0] ** 2 + nums[1] ** 2 == nums[2] ** 2:
        print("right")
    else:
        print("wrong")
    nums = sorted(map(int, input().split()))