import GLOOP.*;
public class main {
    public fpc firstPersonController;
    int fpsBase = 60;
    int sleepTimer = 1000 / fpsBase;
    mapGen mapGenerator = new mapGen();
    main() {
        firstPersonController = new fpc();
        mapGenerator.generateFromFile("map.json");
        while (true) {
            firstPersonController.gameLoop();
            Sys.warte(sleepTimer);
        }
    }
}