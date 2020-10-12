#!/usr/bin/env python
# -*- coding: utf-8 -*-

# 

def two_sum(nums, target):
    index_dict = {}
    for i in range(len(nums)):
        if(target-nums[i]) in index_dict.keys():
            return [index_dict[target-nums[i]], i]

        index_dict[nums[i]] = i