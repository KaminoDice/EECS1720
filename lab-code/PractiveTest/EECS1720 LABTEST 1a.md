# EECS1720 LABTEST 1a (practice)

## 

You have 90 minutes to complete this test.
This is a closed book test (you may use resources linked below).

**Follow the instructions below carefully!!**

------

## RESOURCES

- [Java API](https://www.eecs.yorku.ca/common/java-api)

------

## GETTING STARTED

1. Start eclipse: click **Activities**, and click the last icon (left margin). In the search box, type "eclipse" and launch by clicking on the eclipse icon. Open eclipse in the **default workspace! (i.e. "eclipse-workspace")**
2. Download [this project file](https://www.eecs.yorku.ca/course_archive/2022-23/W/1720/practice/ptest1a.zip) (save to your home directory).
3. Import the test project by doing the following:
   - Under the **File** menu choose **Import...**
   - Under **General** choose **Existing Projects into Workspace** and press **Next**
   - Click the **Select archive file**, and click **Browse...**. You may have to wait for the file browser to appear.
   - In the file browser that appears, navigate to your home directory.
   - Select the file **ptest1a.zip** and click **OK**, then click **Finish**.
4. All of the files you need for this test should now appear in eclipse (in the *eclipse-workspace/ptest1a* directory).
5. You will see several java files. When you submit, only submit *.java files, no class files

------

## QUESTIONS

For each of the following questions, open the relevant java file in Eclipse, and complete the program/method(s) as per the given instructions below. As you complete each, do a submit (remember repeated submits will just overwrite older submissions - be sure to submit regularly)

**You should aim to allocate 25-30 minutes per question**

------

### Question 1 - Exceptions (10 marks)

In `**BirthDate.java** `, read the comments at the beginning of this file to have an idea of the expected behaviour of the application. Then complete the main method, by inserting code where necessary to achieve the expected behaviours.

You will need to make use of services in the `**String** `and `**Integer** `classes primarily, the API's of which can be found through the Java API link at the top of this page. The relevant packages are: `*java.lang.String* `and `*java.lang.Integer* `, while exception API's can be found in `*java.lang.Exception*`

Please refer to the comments in the file that indicate expected behaviour and output for the app overall and for each task.

Note: there is no tester provided for Q1 (this may/may not be provided in actual test)

------

### Question 2 - Class Basics (10 marks)

In `**Counter.java** `you are required to complete the implementation of the basic components of the `**Counter** `class, as specified in the following UML diagram. The `**Counter** `class stores an integer value (that keeps track of a count of things), and a String name (the name of the Counter).

The class can be instantiated, and supports some limited functionality (an accessor that returns a String version of the Counter's state, and two mutators that modify the counter's value). The class consists of 2 fields, 2 constructors, 1 accessor, and 2 mutator methods only (do not create more features than this).

A detailed description of each of these class components is given in the following [Counter API.](https://www.eecs.yorku.ca/course_archive/2022-23/W/1720/practice/ptest1a.api/index.html) Click on the name of each method in the Counter API to jump to its detailed description.

Your task is to complete the implementation of Counter as specified, by completing the code in Counter.java.

NOTE: the second custom constructor requires you to generate an exception if a particular condition is satisfied.

![img](https://www.eecs.yorku.ca/course_archive/2022-23/W/1720/practice/Counter.png)

To test your Counter class, run the file `**Tester.java** `(without any modification). This may/may not be provided in the actual test (however it gives you an idea of how the class will be evaluated)

------

### Question 3 - Written Questions (10 marks)

Please type your answers into the file **answers.txt**.

1. ```
   What keyword is used to explicitly raise an exception?
   
    a) catch
    b) throw
    c) throws
    d) raise
    e) try
    f) throwable
   ```

2. ```
   Which of the following classes relates to the set of exceptions that may be caught in a catch block?
   
    a) Error
    b) Exception
    c) RuntimeException
    d) All of the above
   ```

3. ```
   Given the following code fragment:
   
    String[] myWords = { â€œhelloâ€, â€œadieuâ€, â€œciaoâ€, â€œguten tagâ€ };
    String currWord = myWords[10];
    System.out.println(currWord);
   
   
   The most likely exception to be thrown would be:
   
    a) NullPointerException
    b) ArrayIndexOutOfBoundsException
    c) StringIndexOutOfBoundsException
    d) ArithmeticException
    e) No exceptions would be thrown
   ```

4. ```
   A default constructor for a class A must:
   
    a) always be public if a client wishes to instantiate objects of class A
    b) always be private if a client wishes to instantiate objects of class A securely
    c) always be protected, so that clients can only instantiate valid objects of class A
    d) can never be private
    e) can never be public
   ```

5. ```
   If a class variable is declared as public, then:
   
    a) this means that an object of this class can now be instantiated by an external client
    b) the field associated with that class variable can be modified directly by a client
    c) the class variable can legally be used to represent an object of another class 
    d) a client can only access the class variable via public methods defined for that class
   ```

6. ```
   If class A is a composition of class B, which of the following statements is most accurate?
   
    a) An object of class B "is associated" with an object of class A, however the B object may exist independently from the A object
    b) An object of class B is a specialized â€œversionâ€ of a class A object, and assumes all attributes and fields from the class A
    c) The object of class B "belongs to" an object of class A, such that the B object may only exist as a part of an A object
    d) none of the above
   ```

7. ```
   What does the keyword "static" mean in the context of a class field [2 marks]?
   ```

8. ```
   Briefly explain what is meant by the term "API" - how does this relate to class features [2 marks]?
   ```



------

## SUBMISSION

DO NOT SUBMIT - THIS IS A PRACTICE TEST ONLY!

------