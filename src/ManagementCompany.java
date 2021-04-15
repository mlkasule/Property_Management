
public class ManagementCompany {

	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property[] properties;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Plot plot;

	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, 1, 1);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(0, 0, 10, 10);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
		properties = otherCompany.properties;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public void setMgmFee(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public void setPlot(Plot plot) {
		this.plot = new Plot(plot);
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public double getMgmFee() {
		return mgmFeePer;
	}

	public Plot getPlot() {
		return new Plot(plot);
	}

	public int addProperty(Property property) {

		Property prop = new Property();

		// create a property array to hold each property
		Property[] newProperty = new Property[MAX_PROPERTY];
		// report status every after entry
		int status = 0;

		for (int i = 0; i < newProperty.length; i++) {
			newProperty[i] = property;

			if (property == null) {
				status = -2;
			} else if (newProperty[0].getPlot() != newProperty[i].getPlot()) {
				status = -3;

			} else if (newProperty[i].getPlot().overlaps(property.getPlot())) {
				status = -4;
			} else if (newProperty.length == MAX_PROPERTY) {
				status = -1;
			} else if (newProperty[i] != null) {
				status = i;
			}
		}
		// record sum of properties entered
		return status;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property newProperty = new Property(name, city, rent, owner);

		// add it to property array and store to checkStatus
		int recieveStatus = addProperty(newProperty);

		return recieveStatus;
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);

		// send it to property array and store result to checkStatus
		int recieveStatus = addProperty(newProperty);

		return recieveStatus;
	}

	/**
	 * Access the stored property in the array at index i
	 * 
	 * @param i
	 * @return string of property
	 */
	private String displayPropertyAtIndex(int i) {
		String str = properties[i].toString();
		return str;
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public double maxRentProp() {

		double highestRent = 0; // track max rent
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				highestRent = properties[i].getRentAmount();
			}
		}
		return highestRent;
	}

	private int maxRentPropertyIndex() {

		int highestIndex = 0; // track max index
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	public double totalRent() {
		int total = 0; // track sum
		for (int i = 0; i < properties.length; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}

	/**
	 * print results
	 * 
	 */
	@Override
	public String toString() {

		String str = "";
		for (int i = 0; i < properties.length; i++) {
			str = properties[i].toString();
		}
		return str;
	}

}
