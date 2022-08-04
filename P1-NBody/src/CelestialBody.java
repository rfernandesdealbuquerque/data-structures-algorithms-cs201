

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 *
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;
	private final double G = 6.67*1e-11;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
		
	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		// TODO: complete method
		return this.myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		// TODO: complete method
		return this.myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return this.myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return this.myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		// TODO: complete method
		return this.myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		// TODO: complete method
		return this.myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		return Math.sqrt(Math.pow(this.myXPos - b.myXPos, 2) + Math.pow(this.myYPos - b.myYPos, 2));
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		
		return G*(this.myMass*b.myMass/Math.pow(this.calcDistance(b),2));
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return this.calcForceExertedBy(b)*(Math.sqrt(Math.pow(this.myXPos - b.myXPos,2))/this.calcDistance(b));
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return this.calcForceExertedBy(b)*(Math.sqrt(Math.pow(this.myYPos - b.myYPos,2))/this.calcDistance(b));
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		for(CelestialBody body : bodies) {
			if(this == body) {
				continue;
			}
			else {
				sum += this.calcForceExertedByX(body);
			}
			
		}
		
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		for(CelestialBody body : bodies) {
			if(this == body) {
				continue;
			}
			else {
				sum += this.calcForceExertedByY(body);
			}
			
		}
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
