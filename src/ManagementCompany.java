
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
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
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
	/**
	 * 
	 * @param property
	 * @return
	 */

	public int addProperty(Property property) {

		// create a property array to hold each property

		Property house = new Property(property);

		int status = 0;

		for (int i = 0; i < MAX_PROPERTY; i++) {

			properties[i] = property;

			if (property.equals(null)) {
				status = -2;
			} else if (properties[0].getPlot().encompasses(properties[i].getPlot())) {
				status = -3;

			} else if (properties[i].getPlot().overlaps(properties[0].getPlot())) {
				status = -4;
			} else if (properties.length == MAX_PROPERTY) {
				status = -1;
			} else if (!house.equals(null)) {
				properties[i] = house;
				status = i;
			}
		}
		// record sum of properties entered
		return status;
	}

	public int addProperty(String name, String city, double rent, String owner) {

		Property house = new Property(name, city, rent, owner);
		int status = 0;

		for (int i = 0; i < properties.length; i++) {
			if (house.equals(null)) {
				status = -2;
			} else if (properties[0].getPlot().encompasses(properties[i].getPlot())) {
				status = -3;

			} else if (properties[i].getPlot().overlaps(properties[0].getPlot())) {
				status = -4;
			} else if (properties.length == MAX_PROPERTY) {
				status = -1;
			} else if (!properties[i].equals(null)) {
				properties[i] = house;
				status = i;
			}
		}

		return status;

	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		Property house = new Property(name, city, rent, owner, x, y, width, depth);

		int status = 0;

		for (int i = 0; i < properties.length; i++) {
			if (house.equals(null)) {
				status = -2;
			} else if (properties[0].getPlot().encompasses(properties[i].getPlot())) {
				status = -3;

			} else if (properties[i].getPlot().overlaps(properties[0].getPlot())) {
				status = -4;
			} else if (properties.length == MAX_PROPERTY) {
				status = -1;
			} else if (!properties[i].equals(null)) {
				properties[i] = house;
				status = i;
			}
		}

		return status;
	}

	// print all properties
	public Property propertyList(Property property) {

		for (int i = 0; i < properties.length; i++)
			properties[i] = property;

		return new Property(property);

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


		Property house = new Property();

		double highestRent = 0; // track max rent

		for (int i = 0; i < properties.length; i++) {
			properties[i] = house;
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				highestRent = properties[i].getRentAmount();
			}
		}
		return highestRent;
	}

	private int maxRentPropertyIndex() {

		// property list

		// property
		Property house = new Property();

		int highestIndex = 0; // track max index
		for (int i = 0; i < properties.length; i++) {
			properties[i] = house;
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	public double totalRent() {
		int total = 0; // track sum

		// property
		Property house = new Property();

		for (int i = 0; i < properties.length; i++) {
			properties[i] = house;
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
		// property list
		// Property[] newProperty = new Property[MAX_PROPERTY];

		// house object
		Property house = new Property();

		String str = "";
		for (int i = 0; i < properties.length; i++) {
			properties[i] = house;
			str = properties[i].toString();
		}
		return str;
	}

}
