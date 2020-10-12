def containsDuplicate(nums):
    num_set = set()

    for num in nums:
        if(num in num_set):
            return True
        num_set.add(num)

    return False


print(containsDuplicate([1,1,1,3,3,4,3,2,4,2]))
