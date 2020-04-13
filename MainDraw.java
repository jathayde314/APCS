public class MainDraw {

    public int x_velo = 0;
    public int y_velo = 0;
    public int x;
    public int y;
    public int carWidth;
    public int carHeight;

    public MainDraw(int xpos, int ypos, int width, int height){
        carWidth = width;
        carHeight = height;
        x = xpos;
        y = ypos;

    }

    public void moveRight() {
        x_velo += 1;
    }

    public void moveLeft() {
        x_velo -= 1;
    }

    public void moveDown() {
        y_velo += 1;
    }

    public void moveUp() {
        y_velo -= 1;
    }

    public void resetVelo(){
        x_velo = 0;
        y_velo = 0;
    }

    public void inFrame(int getWidth, int getHeight) {
        if(x+carWidth>getWidth){
            x = getWidth - carWidth;
            x_velo = -x_velo;
        } else if(x<0){
            x=0;
            x_velo = -x_velo;
        }

        if(y+carHeight>getHeight){
            y = getHeight - carHeight;
            y_velo = -y_velo;
        } else if(y<0){
            y=0;
            y_velo = -y_velo;
        }
    }

    void cycle() {

        x += x_velo;
        y += y_velo;
    }
}
