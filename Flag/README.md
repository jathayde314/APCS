# Flag Project

This project contains a flag that scales to fit the size of the window. The code can be easily generalized to contain various numbers of stars and stripes. I have generalized the number of points each star can contain and the relative size can be changed by changing a constant in Star.class.
### Errors

This code currently contains no bugs. Although it does not scale exactly to the size of the window, this is due to rounding errors because exact dimensions would contain decimals yet pixels can only be integers.

### Code Review

Main class runs the programs and initializes the Flag whenever the window size changes. FlagFrame creates a JFrame and runs other methods that paint the stars, the union, the stripes, and the background. Star calculates the dimensions of the star and paints it at the given coordinates. Union paints a scaled Union. Stripes paints scaled stripes. Background paints a scaled background. The code is structured this way to make it easily generalizable: it is easy to change the number of stars or stripes without massive edits to the code. One would only need to change how many times Star() is invoked and change the positions and the JLayeredPane index. The number of stripes can be adjusted within the Stripes() module. 
 
### Major Challenges

I had trouble figuring out how to use JLayeredPane to have the images paint on top of each other neatly.

### Acknowledgements

I would like to thank Ivory and Aaron pointing out an error in the trig used to calculate the outer and inner radii for the stars. This error has since been fixed. 

### Made with

I used javax.swing.*, java.awt.event.ComponentAdapter, java.awt.event.ComponentEvent, java.awt.event.ComponentListener, JFrame, and JLayeredPane. This packages allow me to paint pixels on a window, stack panes on top of each other, and get the width and height of the window when the size is changed.
