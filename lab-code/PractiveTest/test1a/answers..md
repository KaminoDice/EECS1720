
Question 3 answers (type here, save and submit)


// MULTIPLE CHOICE [1 mark each]

1)
b

2)
c

3)
b

4)
b

5)
b

6)
a



// SHORT ANSWER [2 marks each]


7)
private means that the class field is not visible or accessible (cannot be accessed or modified directly from a client of this class), i.e. if the class can be instantiated, and a client program does so (creates a new object of that type), then you cannot access that field using the dot "." syntax. If you cannot access, you also cannot modify that field this way.  The field is essentially hidden to all methods in a program that exist outside that class definition.


8)
an alias occurs when we have more than one reference pointing to the same instance (object) in memory.  E.g. 
```Java
	MyType x = new MyType();  
	MyType y = new MyType();
	MyType z = x;
```
then x, y are NOT aliases (they refer to different objects in memory), while x and z ARE aliases (they both refer to the same object in memory.. the one that was created on the first line of code. 


