import GLOOP.*;
class main {
    GLTastatur mainKey = new GLTastatur();
    int fpsBase = 60;
    int sleepTimer = 1000 / fpsBase;

    main() {
        while (!mainKey.esc()) {

            Sys.warte(sleepTimer);
        }
    }
}