Description

Don't Burn Out is a Java game that works like a small restaurant. The player
answers English, math, or science questions to complete customer orders. The
game keeps track of how many questions the player gets wrong and ends when the
player reaches the chosen limit.

Features

The player can choose between English, math, and science questions. The player
answers questions to complete customer orders, chooses how many wrong answers
are allowed, and progresses through more difficult questions. Custom questions
can also be loaded from a questions.txt file.

Requirements to Compile and Run

You need Java Development Kit, also called JDK, version 8 or newer, a terminal
or command prompt, and the project downloaded on your computer.

The tests use the student.TestCase class from the course's CS2-Support
library. That library is set up in the Eclipse project settings.

Step by Step on How to Compile and Run

Install a Java Development Kit and open the project in your Java IDE. In
Eclipse, open GameManager.java, right-click inside the file, and choose Run As,
then Java Application. You can also select the Run button at the top of
Eclipse. The IDE will compile the project and start the game.

Follow the prompts to enter your name, choose a subject, and choose the maximum
number of wrong answers.

If you are using a different IDE, open GameManager.java and use that IDE's Run
button to start the Java application.

If you choose to load custom questions, put a questions.txt file in the main
project folder. Each question and answer should be separated with the | symbol, and the
questions should be placed under Easy, Medium, or Hard sections.

How to Test

Open the project in Eclipse with the CS2-Support library available. Right-click
a test file in the src/project1 package and choose Run As, then JUnit Test.

The test files include InputHandlerTest, OrderTest, and the other tests in the
same package. They extend student.TestCase, which is why the support
library is needed to run them.

