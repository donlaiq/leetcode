# leetcode
Three solutions for the "40. Combination Sum II" problem. I'll be using the array arr=[10,1,2,7,6,1,5] and the target=8 to explain my approaches.

Aproach1.java: All the possible combinations.

From the size n of a given array, we can infer that there are 2^n possible combinations to sum its elements. Our first approach will be a naive approach, 
where we'll be using all these combinations to find the right solutions. We need to find a metodology to allow or not so add a number, for example, a "0" would mean
not to add it, while a "1" would mean to add it. That way, all the possible combinations will have this form:

0000000
0000001
0000010
...
1111111

The combination 0110001 will add 1+2+5, and it will be one of our solutions. Those combinations resulting in a value different to target will be ignored.
