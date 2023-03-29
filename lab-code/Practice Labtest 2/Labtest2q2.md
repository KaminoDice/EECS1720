# EECS1720 PROGRAMMING TEST 2 (practice)

    You have 120 minutes to complete this test.
 This is an open
	book test.

    **Follow the instructions below carefully!!**

The window for the ACTUAL test will be Wednesday April 7, 12:30pm -
	Thursday April 8, 12:30am. Please ensure that you begin the test within
	this window.

You will be time-stamped upon beginning the test, and will have 2
	hours to complete. There are two questions in total, and you will
	submit two *.java files through web-submit.

---

## RESOURCES

* [Java
  API](https://docs.oracle.com/javase/8/docs/api/)

---

## GETTING STARTED

1. Start eclipse: click  **Activities** , and click the last
   icon (left margin). In the search box, type "eclipse" and launch by
   clicking on the eclipse icon. Open eclipse in the **default
   workspace! (i.e. "eclipse-workspace")**
2. Download [this project file](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/practest2.zip) (save
   to your home directory).
3. Import the test project by doing the following:

   * Under the **File** menu choose **Import...**
   * Under **General** choose **Existing Projects into
     Workspace** and press **Next**
   * Click the  **Select archive file** , and click  **Browse...** .
     You may have to wait for the file browser to appear.
   * In the file browser that appears, navigate to your home
     directory.
   * Select the file **practest2.zip** and click  **OK** ,
     then click  **Finish** .
4. You will see several java files. **Please attempt a
   submit on these files NOW!**

   To submit, upload the files **`Tweeter.java`** and **`CircleDraw.java`**
   to the directory **`practest2`** on web submit:
   [https://webapp.eecs.yorku.ca/submit/](https://webapp.eecs.yorku.ca/submit/).

   Note: there is no submission option for this test as it is
   for practice only.

---

## QUESTIONS

For each of the following questions, open the relevant java file
	in Eclipse, and complete the program/method(s) as per the given
	instructions below. As you complete each, do a submit (remember
	repeated submits will just overwrite older submissions - be sure to
	submit regularly)

    Note: read comments in source files carefully - some parts of the code are already done for you.  You only
	need to complete the parts indicated and discussed in the questions below.

    **You should aim to allocate 50 mins per question (this leaves 10
		mins at the end to upload each question!)**

---

### Question 1 - ActionEvent GUI (30 marks)

    In reference to additional comments and instructions provided in the
	source file**`Tweeter.java`** , you are required to
	complete the implementation of a basic GUI (using Java AWT/Swing) for
	the application Tweeter.java. The GUI for this application has the
	following look and feel:

    ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/tweet1.png)

The application acts as a simple GUI to construct and post
	"tweets" - which are short messages normally posted through the twitter
	portal. This application will simulate the portal. A tweet message has
	a recipient and a message (both using textfields for user input). A
	tweet button (with a bird icon) sends the message, which is appended
	into the tweet stream (the dark scrollable text area at the bottom of
	the application window). Tweeted messages accumulate in the text area
	(each new one below the last).

The application should support the following features/behaviours:

* The application includes two `JLabels` with the text "Recipient:" and "Tweet:" respectively (see figures)
* The application includes two `JTextFields` for indicating the recipient (who a tweet is directed at), and the
  tweet message itself (what will be tweeted). The recipient field is
  initially empty, while the tweet message initially contains the text
  "type tweet here"
* The application includes a `JButton` with no text and a single icon using `TwitterIcon.png` included in the project file. Note that the size of the original icon
  image is large, and has been scaled for you using "getScaledInstance(..)". Use the newly set ImageIcon to create the JButton.
* The text area should conform to the size of the *controls* JPanel (already provided for you in the code).
  This *controls* panel should hold all the GUI components, including the text area (also provided already in the code).
  You need to provide additional code to ensure the text area has scroll access: i.e. it should **always**
  include a
  vertical scrollbar to handle and access all tweets appended to the text
  area; while a horizontal scrollbar should only appear if
  there are tweets that are too wide for the text area.
* The layout does not need to be exact, but should be as close
  as possible to the figures.
* The tweet button should trigger an event that when handled, appends an
  output message in the text area based on the following rules:

  ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/tweet2.png)
  ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/tweet3.png)

  ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/tweet4.png)
  ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/tweet5.png)
* If Recipient and Tweet JTextFields are not empty, output "Tweeting @
  NAME: MESSAGE", where NAME = the string entered in the Recipient
  JTextField, and MESSAGE = the message typed into the Tweet JTextField (see above examples)
* If the Tweet JTextField is empty, output "You forgot to tweet!"
* If the Recipient JTextField only is empty, output "Tweeting @ the world:
  MESSAGE"
* All of the above UI components are placed into a
  centralized panel within a border (code already done for you)
* Design an Event listener as an inner (nested) class to respond to the JButton as per the above examples.

---

### Question 2 - Mouse/KeyEvent GUI (30 marks)

    In this question, the goal is to complete the GUI application in`CircleDraw.java`
	that captures and processes mouse-based events to achieve the simple placement and sizing
	of a circle on a custom canvas. Shell code has been provided for you that lays out the GUI elements.
    Your job is to complete the application (primarily the custom canvas class, and the handler class).

 In this application, a circular shape is constructed when the user clicks and drags the mouse in the
	canvas area. As the user drags the mouse, the circle is displayed in WHITE, and continuously resizes
	until the mouse button is released, at which point it remains fixed.  In addition, a set of RED axes
	are drawn through the centre of the circle. When the user clicks again, a new circle and axes
	replace the old one.

    A status JLabel located at the bottom of the window
	outputs some information about the circle and its radius as it is being constructed.

    ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/circleDraw1.png)
    ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/circleDraw2.png)
    ![](https://www.eecs.yorku.ca/course_archive/2020-21/W/1720/practice/circleDraw3.png)

The application should support the following features/behaviours:

* The custom canvas inherits from JPanel, and overrides the paintComponent method.
* When the user clicks into the custom canvas with the mouse, a centre point is selected for
  drawing a circle.  Continuing to hold the mouse button down while dragging will compute a radius for the
  circle (distance from the point first clicked)
* As the user drags the mouse, a circle of the computed radius will display as white, while a set of
  red lines representing an x and y axis through the centre of the circle will also be displayed
* When the user releases the mouse button, the circle will remain fixed at the last radius determined before release
* As the mouse is being dragged, the status JLabel should show the
  string "Status: drawing circle: (XX,YY) radius = RR",
  where XX = the x coordinate initially clicked (at the centre of the
  circle), YY = the y coordinate initially clicked (at centre of
  the circle), and RR = the radius of the circle.  This status is
  continuously refreshed as the user drags the mouse.

  *Note: you may consider using `Line2D.Double` and `Ellipse2D.Double` from
  `java.awt.geom` when drawing the circle and axes (though it is not necessary).  Also, `Point2D.Double` objects have a method for computing distance to another Point2D.Double object.
  This can be useful for quickly calculating radius.*

---
