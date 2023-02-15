Question 3 answers (SOLUTION)


// MULTIPLE CHOICE [1 mark each]

1)  b. throw


2)  d. all of the above


3)  b. ArrayIndexOutOfBoundsException

	** StringIndexOutOfBounds only occurs if incorrectly indexing a character position in a string


4)  a. always be public if a client wishes to instantiate objects of class A

	** an object is always instantiated externally, so we must have public access to at least one constructor	


5)  b. the field associated with that class variable can be modified directly by a client

	** if a field is public it is always directly accessible

6)  c. The object of class B "belongs to" an object of class A, such that the B object may only exist as a part of an A object

	** composition implies ownership



// SHORT ANSWER [2 marks each]


7)
	static = "only one copy" - this field has a single copy stored within the class definition
	(not stored in any instances) and generally must be accessed via the class name


8)
	API = "Application Programming Interface" - this generally refers to all of the public features 
	(fields, constructors or methods) that are accessible to a client program that wants to use this class

	** i.e. any private features are not considered part of the API as they are effectively hidden from a client