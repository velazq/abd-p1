package abd.p1.math;

public class SphericalGeometry {
	
	private static final int R = 6371000;

	public SphericalGeometry() {
		// TODO Auto-generated constructor stub
	}
	
	public static double haversineFormula(double phi1, double theta1, double phi2, double theta2) {
		double phiDiff = phi1 - phi2;
		double thetaDiff = theta1 - theta2;
		double sinSqPhi = Math.pow(Math.sin(phiDiff / 2), 2);
		double sinSqTheta = Math.pow(Math.sin(thetaDiff / 2), 2);
		double a = sinSqPhi + Math.cos(phi1) * Math.cos(phi2) + sinSqTheta;
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return R * c;
	}
	
	public static double degToRad(double deg) {
		return deg * Math.PI / 180;
	}
	
	public static double radToDeg(double rad) {
		return rad * 180 / Math.PI;
	}

}
