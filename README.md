# FindingKShortestPath


<b>Input File:</b> 

S:5,D:13 </br>
1. 5(3),8(2),3(5) </br>
2. 3(10),4(4) </br>
3. 6(2),3(5) </br>
. </br>
. </br>
. </br>
N. ... ,... ,... </br>

S: Starting Index, D: Destination Index </br>

<b>1</b> ------3------> <b>5</b> (From 1 to 5, path length is 3) </br>
<b>1</b> ------2------> <b>8</b> (From 1 to 8, path length is 2) </br>
<b>1</b> ------5------> <b>3</b> (From 1 to 3, path length is 5) </br>

<b>2</b> ------10------> <b>3</b> (From 2 to 3, path length is 10) </br>
<b>2</b> ------4------> <b>4</b> (From 2 to 4, path length is 4) </br>
...

<b>Output File:</b> 

K shortest paths(1. shortest path, 2. shortest path, 3. shortest path, ..., K. shortest path) with their lengths

<b>Running The Program</b>

```
javac Main.java
java Main
```

<b>Note:</b> input.txt file must be exist. You can change it in 23.line of Main.java
