
# 1632. Rank Transform of a Matrix
## Visual explanation.

```
matrix =  20 -21 14  
         -19  19  4    
          22 -47 24
         -19  19  4
         
sol = 0 0 0
      0 0 0 
      0 0 0
      0 0 0
```

### Step 1: 
list = **-47** -21 -19 -19 4 4 14 19 19 20 22 24
The coordinate is (2, 1). The highest value of the row 2 is 0. The highest value of the column 1 is 0.
The new rank should be 1.

```
sol = 0 0 0
      0 0 0 
      0 1 0
      0 0 0
```

### Step 2: 
list = -47 **-21** -19 -19 4 4 14 19 19 20 22 24
The coordinate is (2, 1). The highest value of the row 2 is 0. The highest value of the column 1 is 0.
The new rank should be 1.

```
sol = 0 2 0
      0 0 0 
      0 1 0
      0 0 0
```
