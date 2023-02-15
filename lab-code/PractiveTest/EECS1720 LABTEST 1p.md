# EECS1720 LABTEST 1p

## 

You have 80 minutes to complete this test.
This is a closed book test (you may use resources linked below).

**Follow the instructions below carefully!!**

The test will begin at 11.30am and will end at 12:50pm (you will have a 5 minute warning to submit your work)

------

## RESOURCES

- [Java API](https://www.eecs.yorku.ca/common/java-api)

------

## GETTING STARTED

1. Start eclipse: click **Activities**, and click the last icon (left margin). In the search box, type "eclipse" and launch by clicking on the eclipse icon. Open eclipse in the **default workspace! (i.e. "eclipse-workspace")**

2. Download [this project file](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/test1p.zip) (save to your home directory).

3. Import the test project by doing the following:

   - Under the **File** menu choose **Import...**
   - Under **General** choose **Existing Projects into Workspace** and press **Next**
   - Click the **Select archive file**, and click **Browse...**. You may have to wait for the file browser to appear.
   - In the file browser that appears, navigate to your home directory.
   - Select the file **test1p.zip** and click **OK**, then click **Finish**.

4. All of the files you need for this test should now appear in eclipse.

5. Open a terminal. You will use this terminal to submit your work.

6. Copy and paste the following command into the terminal and press enter:

   ```
   cd
   cd eclipse-workspace/test1p
   ```

7. You will see several java files.

    

   Please attempt a submit on these files NOW!

   To do this, copy and paste the following command into the terminal and press enter:

   ```
   submit 1720 test1p *.java
   ```

   You should see the following message if submission occurred successfully:

   ```
   submitted:  Ratio.java (61 bytes)
   submitted:  Fraction.java (61 bytes)
   All files successfully submitted.
    
   ```

   During the test, please keep this terminal open, and use it to submit

    

   regularly

   . Do this by simply clicking into the open terminal window, press the up arrow key to find your previous submit command, and hit enter to re-submit.

   There will be a 5 min warning near the end of the test. Please re-submit immediately when you get that warning!! The lab machine **will** shutdown at the end of the allotted test time.

   ASIDE: To check the files that have been submitted, you may copy and paste the following command to your terminal and hit enter.

   ```
   submit -l 1720 test1p 
   ```

------

## QUESTIONS

For each of the following questions, open the relevant java file in Eclipse, and complete the program/method(s) as per the given instructions below. As you complete each, do a submit (remember repeated submits will just overwrite older submissions - be sure to submit regularly)

**You should aim to allocate 35 minutes per question, this leaves 10 minutes at end!**

------

### Question 1 - Exceptions (15 marks)

In `**Ratio.java**`, read the comments at the beginning of this file to have an idea of the expected behaviour of the application. Then follow the instructions within the main method to complete tasks 1-4, by inserting code where necessary to complete these tasks.

You will need to make use of services in the `**String**` and `**Integer**` classes primarily, the API's of which can be found through the Java API link at the top of this page. The relevant packages are: `*java.lang.String*` and `*java.lang.Integer*`, while exception API's can be found in `*java.lang.Exception*`

Please refer to the comments in the file that indicate expected behaviour and output for the app overall and for each task.

------

### Question 2 - Class Basics (15 marks)

In `**Fraction.java**` you are required to complete the implementation of the basic components of the `**Fraction**` class, as specified in the following UML diagram. The `**Fraction**` class stores integer values for both a numerator and denominator to represent a given fraction.

The class can be instantiated, and supports some limited functionality (accessors that return two alternative String versions of the Fraction's state). The class consists of 2 fields, 3 constructors and 2 accessor methods only (do not create more features than this).

A detailed description of each of these class components is given in the following [Fraction API.](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/test1p.api/index.html)

Your task is to complete the implementation of Fraction as specified, by completing the code in Fraction.java.

NOTE: the custom constructor requires you to generate an exception if a particular condition is satisfied.

![img](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/Fraction.png)

------

## SUBMISSION

To submit, again, copy and paste the following into the terminal window you opened earlier, and hit enter:

```
submit 1720 test1p *.java
```

------