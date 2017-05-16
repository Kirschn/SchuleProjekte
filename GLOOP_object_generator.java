import GLOOP.*;
public class GLOOP_object_generator {
    GLWuerfel[][] wuerfelArray = new GLWuerfel[32][32];
    GLBoden elBoden = new GLBoden();
    public void createBlock(int x, int y, int generalMapScale) {
            wuerfelArray[x][y] = new GLWuerfel(x * generalMapScale, generalMapScale / 2, y * generalMapScale, generalMapScale);
    }

}