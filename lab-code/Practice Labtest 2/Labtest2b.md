# EECS1720 LABTEST 2b

    You have 80 minutes to complete this test.

    This is a closed book test (you may use resources linked below).

    **Follow the instructions below carefully!!**

    The test will begin at 11:30am and will end at 12:50pm (you will have a 5 minute warning to submit your work)

---

## RESOURCES

* [Java API](https://www.eecs.yorku.ca/common/java-api/)

---

## GETTING STARTED

1. Start eclipse: click  **Activities** , and click the last icon
   (left margin). In the search box, type "eclipse" and launch by clicking
   on the eclipse icon.  Open eclipse in the **default workspace! (i.e. "eclipse-workspace")**
2. Download [this project file](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/test2b.zip) (save to your home directory).
3. Import the test project by doing the following:

   * Under the **File** menu choose **Import...**
   * Under **General** choose **Existing Projects into Workspace**
     and press **Next**
   * Click the  **Select archive file** , and click
     **Browse...** . You may have to wait for the file browser to appear.
   * In the file browser that appears, navigate to your home directory.
   * Select the file **test2b.zip** and click  **OK** , then click  **Finish** .
4. All of the files you need for this test should now appear in eclipse.
5. Open a terminal. You will use this terminal to submit your work.
6. Copy and paste the following command into the terminal and press enter:

   ```
   cd
   cd eclipse-workspace/test2b
   ```
7. You will see several java files. **Please attempt a submit on these files NOW!**

   To do this, copy and paste the following command into the terminal and press enter:

   ```
   submit 1720 test2b *.java
   ```

   You should see the following message if submission occurred successfully:

   ```

   submitted:  Square.java (61 bytes)
   submitted:  Rectangle.java (61 bytes)
   submitted:  Resizeable.java (61 bytes)
   submitted:  SquareFootCalculator.java (61 bytes)
   submitted:  Shape.java (61 bytes)
   submitted:  Alignment.java (61 bytes)
   submitted:  TestClient.java (61 bytes)
   All files successfully submitted.

   ```

   During the test, please keep this terminal open, and use it to submit  **regularly** .
   Do this by simply clicking into the open terminal window, press the up
   arrow key to find your previous submit command, and hit enter to
   re-submit.

   **There will be a 5 min warning near the end of the test.  Please
   re-submit immediately when you get that warning!! The lab machine **will** shutdown at the end of the allotted test time.**

   ASIDE: To check the files that have been submitted, you may copy and paste the following command to your terminal and hit enter.

   ```
   submit -l 1720 test2b 
   ```

---

## QUESTIONS

For each of the following questions, open the relevant java files in Eclipse,
and complete the program/method(s) as per the given instructions below.  As you complete each, do a submit
(remember repeated submits will just overwrite older submissions - be sure to submit regularly)

**You should aim to allocate 35 minutes per question, this leaves 10 minutes at end!**

---

### Question 1 - Inheritence (30 marks)

Referring to the UML diagram shown below, the goal of this Question is to complete the 2 empty classes: `<b>Square</b>`, `<b>Rectangle</b>`.
  Note that files have been added to the project (Square.java and
Rectangle.java, however there is no shell code included within those
files).  Please complete the code in those files, such that they conform
 to the UML specifications and the additional details laid out in the
description below.

![](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/ShapeSizeable2.png)

* `<b>Square</b>` and `<b>Rectangle</b>` are both child classes of `<b>Shape</b>`.
* The `<b>Square</b>` class implements:

  * a default constructor: where by default, a square has a length of "10" and a position "LEFT".
  * a custom constructor: that uses arguments to set position, length and color (note `java.awt.Color` class is used for Color)
  * a concrete version of the `showMe()` method which outputs the state of a Square as per the example output shown below
  * concrete versions of the `reset()` and `resize(double scale)` methods which are explained further as follows
* The `Rectangle` class implements:

  * a default constructor: where by default, a rectangle has a width of "10", a height of "20", a position "RIGHT", and a RED Color.
  * a custom constructor: that uses arguments to set position, width, height and color (note `java.awt.Color` class is used for Color)
  * a concrete version of the `showMe()` method which outputs the state of a Rectangle as per the example output shown below
  * concrete versions of the `reset()` and `resize(double scale)` methods which are explained further as follows
* Both `<b>Square</b>` and `<b>Rectangle</b>` should conform to the `<b>Resizeable</b>`
  interface (via the Shape class), such that their size based attributes
  (length, width, height and scale) are modified only - according to the
  next two bullet points
* The interface `<b>Resizeable</b>` defines a method `<b>reset()</b>`
  that will set the size of any length/size based attributes for an
  object, back to their original size.  This is done by dividing these
  attributes by the current scale, then re-setting them to these new
  values, and re-setting the scale back to 1.0
* The interface `<b>Resizeable</b>` defines a method `<b>resize(double scale)</b>`
  that will scale and set the size of any length/size based attributes
  for an object, to a new size based on the scale provided.  Scale is
  assumed to be a positive number.  Resizing amounts to 3 steps:

  * generate a RuntimeException if the scale is negative (do not handle just throw) [optional]
  * reset any size based attributes to their original size (as per the reset method), and reset scale
  * scale the size based attributes (i.e. multiply by "scale" argument)
  * set the new value of scale

To test your classes, run the file `<b>TestClient.java</b>`
(without any modification). There should be absolutely NO modification
of the Shape class either.  The output of the test client should be as
follows:

```

TEST 1:
=======
output:
s2 (before resize):
 I am a Square:
	Length: 15.6
	Position: TOP
	Scale: 1.0
	Color: java.awt.Color[r=0,g=0,b=255]

s2 (x1.5 resize):
 I am a Square:
	Length: 23.4
	Position: TOP
	Scale: 1.5
	Color: java.awt.Color[r=0,g=0,b=255]

s2 (after reset):
 I am a Square:
	Length: 15.6
	Position: TOP
	Scale: 1.0
	Color: java.awt.Color[r=0,g=0,b=255]


TEST 2:
=======
output:
r2 (before resize):
 I am an Rectangle:
	Width: 15.0
	Height: 10.0
	Position: TOP
	Scale: 1.0
	Color: java.awt.Color[r=0,g=0,b=255]

r2 (x1.5 resize):
 I am an Rectangle:
	Width: 22.5
	Height: 15.0
	Position: TOP
	Scale: 1.5
	Color: java.awt.Color[r=0,g=0,b=255]

r2 (after reset):
 I am an Rectangle:
	Width: 15.0
	Height: 10.0
	Position: TOP
	Scale: 1.0
	Color: java.awt.Color[r=0,g=0,b=255]

```

---

### Question 2 - Simple Java AWT/Swing GUI (30 marks)

In reference to additional comments and instructions provided in the source file `<b>SquareFootCalculator.java</b>` file, you are required to complete the implementation of a basic GUI and event handler for the JavaFX application: `<b>SquareFootCalculator</b>`.  This simple GUI should have the following features:

    ![](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/SquareFootOpen.png)

* The application includes a `<b>Label</b>` with the text "Height:", and an empty `<b>TextField</b>`  for capturing the height of an area
* The application includes a second `<b>Label</b>` with the text "Width:" and an associated `<b>TextField</b>` for capturing the width of an area
* The application should include a clickable `<b>Button</b>`
  to trigger an Event to calculate the square footage of the area defined
  by height x width. The button should display the text "calculate area
  (sq ft)", and should be located below the Height and Width TextFields
* There should be two `<b>RadioButtons</b>` to the right of
  the TextFields, for selecting the units for the calculation (either
  metres "m", or feet "ft").  See the intended layout above.  Selecting
  one of these buttons will automatically deselect the other, and
  initially, "m" should be selected
* All above UI controls should be placed in a GridPane layout
* The Event handler can be an inner class or external class that can respond to an ActionEvent on the calculate area button
* The Event triggered by the calculate area button should show an
  output message to the console based on the contents of the text fields,
  and the state of the radiobutton.  If the units is "m", then the width
  and height will both be converted to feet before calculating the square
  feet (height x width).  You may use the conversion: 1 m = 3.28084 ft
  (included in the java file already).  Some example outputs are shown
  below:

  * Example 1: If either height or width is empty, then the result written to the console should be:

    ![](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/SquareFootNothing.png)

    ```
    "One or more dimensions is empty!"
    ```
  * Example 2: If height=10.0, width=1, and the units selected are "m", then the result written to the console should be:

    ![](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/SquareFootM.png)

    ```
    "Total Area = 107.63911105599999 sq. ft"
    ```
  * Example 3: If height=15.0, width=3.5, and the units selected are in "ft", then the result written to the console should be:

    ![](https://www.eecs.yorku.ca/course_archive/2019-20/W/1720/practice/SquareFootFT.png)

    ```
    "Total Area = 52.5 sq. ft"
    ```

  ---

  ## SUBMISSION

  To submit, again, copy and paste the following into the terminal window you opened earlier, and hit enter:


  ```
  submit 1720 test2b *.java
  ```

  ---
