import GLOOP.*;
class main {
    GLTastatur mainKey = new GLTastatur();
    int sleepTimer
    main() {
        while (!mainKey.esc()) {

            Sys.warte(sleepTimer);
        }
    }
}