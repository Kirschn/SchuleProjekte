import GLOOP.*;
public class GLOOP_object_generator {
    GLWuerfel[][] wuerfelArray = new GLWuerfel[32][32];
    GLBoden elBoden = new GLBoden("boden.png");
    public void createBlock(int x, int y, int generalMapScale) {
            System.out.println("Generating Block at " + x * generalMapScale + " " +y * generalMapScale);
            wuerfelArray[x][y] = new GLWuerfel(x * generalMapScale + generalMapScale, generalMapScale / 2, y * generalMapScale  + generalMapScale, generalMapScale);
            wuerfelArray[x][y].setzeSelbstleuchten(255,255,255);
            wuerfelArray[x][y].setzeTextur("Wall.jpg");
    }
    public void createWinBlock(int x, int y, int generalMapScale) {
            System.out.println("Generating Win Block at " + x * generalMapScale + " " +y * generalMapScale);
            wuerfelArray[x][y] = new GLWuerfel(x * generalMapScale + generalMapScale, generalMapScale / 2, y * generalMapScale  + generalMapScale, generalMapScale);
            wuerfelArray[x][y].setzeSelbstleuchten(255,0,255);
    }
    public boolean isBlock(int x, int y) {
        if (wuerfelArray[x][y] != null) {
            return true;
        } else {
            return false;
        }
    }

}