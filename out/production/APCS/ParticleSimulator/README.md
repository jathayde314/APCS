# Particle Simulator Project

This project contains a block whose velocity can be controlled using the arrow keys. The block will bounce against the sides of the window, which can be scaled. The goal is for this project to have a variable number of blocks of variable sizes that bounce against the walls and each other.

### Errors

This code currently contains no bugs. At high speeds, the motion of the block becomes less smooth, but this can be attributed to the speed of the Thread.

### Code Review

Main extends JFrame and initializes a new Board and sets some basic constraints. Board extends JContentPane runs a Thread to animate the block and changes the velocity when it hits a wall. MainDraw keeps track of a block's velocity. To generalize the code further, I will need to move some features of Board into MainDraw, so that each instance of MainDraw contains all the position, size, and velocity fields of a block.
 
### Major Challenges

I had trouble figuring out how to use Threads, but I eventually figured it out. I also had trouble getting both Runnable and KeyListener to work at the same time.

### Acknowledgements

I would like to thank a Stack Overflow thread for pointing out that a JContentPane needs to be set to focusable for both Runnable and KeyListener to work. I would also like to thank code posted by Mr. Kuszmaul to schoology and by zetcode.com's star animation for help with structure.

### Made with

I used KeyListener, Runnable, and Graphics (Swing). KeyListener enables the code to change the velocity of the block. Runnable enables the use of a thread to animate movement. Swing enables the code to create images.
