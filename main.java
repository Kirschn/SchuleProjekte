import GLOOP.*;
class main {
    GLTastatur mainKey = new GLTastatur("boden.png");
    int fpsBase = 60;
    int sleepTimer = 1000 / fpsBase;
    mapGen mapGenerator = new mapGen();
    main() {
        mapGen.generateFromFile("map.json");
        while (!mainKey.esc()) {

            Sys.warte(sleepTimer);
        }
    }
}