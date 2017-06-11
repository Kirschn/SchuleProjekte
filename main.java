import GLOOP.*;
public class main {
    int fpsBase = 60;
    int sleepTimer = 1000 / fpsBase;
    mapGen mapGenerator = new mapGen();
    GLKamera cam = new GLKamera(1024,768);
    GLTastatur keyboard = new GLTastatur();
    GLMaus mouse = new GLMaus();
    double lookdir = 3;
    int schwenkQueue = 0, posX, posY;
    boolean buttonPressed = false;
    main() {
        mapGenerator.generateFromFile("map.json");
        cam.setzePosition(200,100,200);
        cam.setzeBlickpunkt(200,100,199);
        while (!keyboard.esc()) {
            if (keyboard.links() && !buttonPressed) {
                buttonPressed = true;
                lookdir--;
                schwenkQueue += -90;
            } else if (keyboard.rechts() && !buttonPressed) {
                buttonPressed = true;
                lookdir++;
                schwenkQueue += 90;
            }
            if (lookdir == 4) {
                lookdir = 0;
            }
            if (lookdir == -1) {
                lookdir = 3;
            }
            if (keyboard.oben() && !buttonPressed) {
                System.out.println("Camera is " + cam.gibX() + " " + cam.gibZ());
                buttonPressed = true;
                if (lookdir == 0 && mapGenerator.canMoveTo(posX+1, posY)) {
                    posX++;
                    cam.verschiebe(200,0,0);
                } 
                if (lookdir == 1 && mapGenerator.canMoveTo(posX, posY+1)) {
                    posY++;
                    cam.verschiebe(0,0,200);
                } 
                if (lookdir == 2 && mapGenerator.canMoveTo(posX-1, posY)) {
                    posX--;
                    cam.verschiebe(-200,0,0);
                } 
                if (lookdir == 3 && mapGenerator.canMoveTo(posX, posY-1)) {
                    posY--;
                    cam.verschiebe(0,0,-200);
                } 
            }
            if (keyboard.unten() && !buttonPressed) {
                System.out.println("Camera is " + cam.gibX() + " " + cam.gibY());
                buttonPressed = true;
                if (lookdir == 0 && mapGenerator.canMoveTo(posX-1, posY)) {
                            cam.verschiebe(-200,0,0);
                            posX--;
                } 
                if (lookdir == 1 && mapGenerator.canMoveTo(posX, posY-1)) {
                            cam.verschiebe(0,0,-200);
                            posY--;
                    } 
                if (lookdir == 2 && mapGenerator.canMoveTo(posX+1, posY)) {
                            cam.verschiebe(200,0,0);
                            posX++;
                } 
                if (lookdir == 3 && mapGenerator.canMoveTo(posX, posY-1)) {
                            cam.verschiebe(0,0,200);
                            posY++;
                } 
            }
            if (!keyboard.istGedrueckt() && buttonPressed) {
                buttonPressed = false;
            }
            if(schwenkQueue != 0) {
                if (schwenkQueue > 0) {
                    schwenkQueue -= 3;
                    cam.schwenkeHorizontal(3);
                } else if (schwenkQueue < 0) {
                    schwenkQueue += 3;
                    cam.schwenkeHorizontal(-3);
                }
            }
            Sys.warte(sleepTimer);
        }
    }
}