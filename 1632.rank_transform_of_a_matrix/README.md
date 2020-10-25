
# 1632. Rank Transform of a Matrix
## Visual explanation.

```
matrix =  20 -21 14  
         -19  19  4    
          22 -47 24
         -19   4 19
         
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
The coordinate is (0, 1). The highest value of the row 0 is 0. The highest value of the column 1 is 1.
The new rank should be 2.

```
sol = 0 2 0
      0 0 0 
      0 1 0
      0 0 0
```

### Step 3: 
list = -47 -21 **-19** -19 4 4 14 19 19 20 22 24
The coordinate is (1, 0). The highest value of the row 1 is 0. The highest value of the column 0 is 0.
The new rank should be 1.
We get the same result if we start from the coordinate (3, 0).

```
sol = 0 2 0
      1 0 0 
      0 1 0
      0 0 0
```

### Step 4: 
list = -47 -21 -19 **-19** 4 4 14 19 19 20 22 24
The coordinate is (3, 0). matrix[1][0] == matrix[3][0], then sol[3][0] should be the same than sol[1][0].

```
sol = 0 2 0
      1 0 0 
      0 1 0
      1 0 0
```


### Step 5: 
list = -47 -21 -19 -19 **4** 4 14 19 19 20 22 24
The coordinate is (1, 2). The highest value of the row 1 is 1. The highest value of the column 2 is 0.
The new rank should be 2.
We get the same result if we start from the coordinate (3, 1).

```
sol = 0 2 0
      1 0 2 
      0 1 0
      1 0 0
```

### Step 6: 
list = -47 -21 -19 -19 4 **4** 14 19 19 20 22 24
The coordinate is (3, 1). The highest value of the row 3 is 1. The highest value of the column 1 is 2.
The new rank should be 3.

```
sol = 0 2 0
      1 0 2 
      0 1 0
      1 3 0
```

### Step 7: 
list = -47 -21 -19 -19 4 4 **14** 19 19 20 22 24
The coordinate is (0, 2). The highest value of the row 0 is 2. The highest value of the column 2 is 2.
The new rank should be 3.

```
sol = 0 2 3
      1 0 2 
      0 1 0
      1 3 0
```

### Step 8: 
list = -47 -21 -19 -19 4 4 14 **19** 19 20 22 24
The coordinate is (1, 1). The highest value of the row 1 is 2. The highest value of the column 1 is 3.
The new rank should be 4.
We get the same result if we start from the coordinate (3, 2).

```
sol = 0 2 3
      1 4 2 
      0 1 0
      1 3 0
```
