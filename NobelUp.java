package projeto;
import robocode.*;
import java.awt.Color;

/**
 * NobelUp - a class by (01549607 -> DAVI P F BARROS)
 */
public class NobelUp extends Robot {
    public void run() {
	    setColors (Color.pink, Color.white, Color.white, Color.pink, Color.white); // Chassi - Canhão - Radar - Tiro - Mira
        
     // Ações do Robô
         while (true) {
                turnGunRight(75);
                ahead(50);	
				back(25);	
				turnGunRight(79); 
                turnGunLeft(55);
				ahead(50);	
				back(25);	
				turnGunRight(79);
				turnGunLeft(55);
				ahead(50);	
				back(25);	
				ahead(50);	
				back(25);
}
	}
	// após inimigo detectado / ocorre o aumento do nível do tiro, dependendo da distância.
	public void onScannedRobot(ScannedRobotEvent e) {
		String robotank = e.getName();
		double distancia = e.getDistance();
		System.out.println(robotank + " distância " + distancia);
        if (distancia < 136) {
			fire(3);
		} else {
			fire(2);
		}	
        // Mira segue o inimigo após detectado.
        turnGunRight(getHeading() - getGunHeading() + e.getBearing());
        fire(1);
	}
	// Ação (Movimentar) ao ser atingido.
    public void onHitByBullet(HitByBulletEvent e) {
       turnLeft(50); 
       ahead(80);
		}
	// Ação (Retornar) após colisão em parede.
	public void onHitWall (HitWallEvent e) {
		back(50);
		turnRight(80);
	}
}
