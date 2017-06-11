import GLOOP.*;
public class fpc {
	GLEntwicklerkamera cam = new GLEntwicklerkamera();
	GLTastatur keyboard = new GLTastatur();
	GLMaus mouse = new GLMaus();
	double lookdir, posX, posY, posZ;
	boolean buttonPressed = false;
	fpc () {
		//while (!keyboard.esc()) {
		//	this.gameLoop();
		//	System.warte(1/60);
		//}
	}
	GLTastatur tastatur () {
		return keyboard;
	}
	public void gameLoop() {
		if (keyboard.links() && !buttonPressed) {
			buttonPressed = true;
			lookdir--;
			cam.schwenkeHorizontal(-90);
		} else if (keyboard.rechts() && !buttonPressed) {
			buttonPressed = true;
			lookdir++;
			cam.schwenkeHorizontal(90);
		}
		if (lookdir == 4) {
			lookdir = 0;
		}
		if (lookdir == -1) {
			lookdir = 3;
		}
		if (keyboard.oben() && !buttonPressed) {
			buttonPressed = true;
			if (lookdir == 0) {
				cam.verschiebe(200,0,0);
			} 
			if (lookdir == 1) {
				cam.verschiebe(0,0,200);
			} 
			if (lookdir == 2) {
				cam.verschiebe(-200,0,0);
			} 
			if (lookdir == 3) {
				cam.verschiebe(0,0,-200);
			} 
		}
		if (keyboard.unten() && !buttonPressed) {
			buttonPressed = true;
			if (lookdir == 0) {
				cam.verschiebe(-200,0,0);
			} 
			if (lookdir == 1) {
				cam.verschiebe(0,0,-200);
			} 
			if (lookdir == 2) {
				cam.verschiebe(200,0,0);
			} 
			if (lookdir == 3) {
				cam.verschiebe(0,0,200);
			} 
		}
		if (!keyboard.istGedrueckt() && buttonPressed) {
			buttonPressed = false;
		}

	}
}