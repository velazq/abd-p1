package abd.p1.math;

public class SphericalGeometry {
	
	private static final int R = 6371000;

	private SphericalGeometry() {
	}
	
	public static double haversineFormula(double lat1, double long1, double lat2, double long2) {
		double phiDiff = lat1 - lat2;
		double thetaDiff = long1 - long2;
		double sinSqPhi = Math.pow(Math.sin(phiDiff / 2), 2);
		double sinSqTheta = Math.pow(Math.sin(thetaDiff / 2), 2);
		double a = sinSqPhi + Math.cos(lat1) * Math.cos(lat2) + sinSqTheta;
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return R * c;
	}
	
	public static double haversineFormulaDegrees(double lat1, double long1, double lat2, double long2) {
		return haversineFormula(degToRad(lat1), degToRad(long1), degToRad(lat2), degToRad(long2));
	}
	
	public static double degToRad(double deg) {
		return deg * Math.PI / 180;
	}
	
	public static double radToDeg(double rad) {
		return rad * 180 / Math.PI;
	}

}
