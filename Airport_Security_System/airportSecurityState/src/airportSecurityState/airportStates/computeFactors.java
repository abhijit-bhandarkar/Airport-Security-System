package airportSecurityState;

import java.util.ArrayList;

public class computeFactors {

	private int tempDayNumber;
	private int totalPlanes = 0;
	private int prohibitedItemCount = 0;
	private String tempItem;
	private double averageTraffic = 0;
	private double averageProhibitedItems = 0;

	/**
	 * @return the tempDayNumber
	 */
	public int getTempDayNumber() {
		return tempDayNumber;
	}

	/**
	 * @param tempDayNumber
	 *            the tempDayNumber to set
	 */
	public void setTempDayNumber(int tempDayNumber) {
		this.tempDayNumber = tempDayNumber;
	}

	/**
	 * @return the totalPlanes
	 */
	public int getTotalPlanes() {
		return totalPlanes;
	}

	/**
	 * @param totalPlanes
	 *            the totalPlanes to set
	 */
	public void setTotalPlanes(int totalPlanes) {
		this.totalPlanes = totalPlanes;
	}

	/**
	 * @return the prohibitedItemCount
	 */
	public int getProhibitedItemCount() {
		return prohibitedItemCount;
	}

	/**
	 * @param prohibitedItemCount
	 *            the prohibitedItemCount to set
	 */
	public void setProhibitedItemCount(int prohibitedItemCount) {
		this.prohibitedItemCount = prohibitedItemCount;
	}

	/**
	 * @return the tempItem
	 */
	public String getTempItem() {
		return tempItem;
	}

	/**
	 * @param tempItem
	 *            the tempItem to set
	 */
	public void setTempItem(String tempItem) {
		this.tempItem = tempItem;
	}

	/**
	 * @return the averageTraffic
	 */
	public double getAverageTraffic() {
		return averageTraffic;
	}

	/**
	 * @param averageTraffic
	 *            the averageTraffic to set
	 */
	public void setAverageTraffic(double averageTraffic) {
		this.averageTraffic = averageTraffic;
	}

	/**
	 * @return the averageProhibitedItems
	 */
	public double getAverageProhibitedItems() {
		return averageProhibitedItems;
	}

	/**
	 * @param averageProhibitedItems
	 *            the averageProhibitedItems to set
	 */
	public void setAverageProhibitedItems(double averageProhibitedItems) {
		this.averageProhibitedItems = averageProhibitedItems;
	}

	/**
	 * @return the prohibitedItems
	 */
	public double getProhibitedItems() {
		return averageProhibitedItems;
	}

	/**
	 * @param prohibitedItems
	 *            the prohibitedItems to set
	 */
	public void setProhibitedItems(double prohibitedItems) {
		this.averageProhibitedItems = prohibitedItems;
	}

	/**
	 * Helper function to calculate Average Traffic
	 * @param dayNum
	 * @param totalPlanes
	 * @return
	 */
	public double calulateAverageTraffic(int dayNum, int totalPlanes) {
		averageTraffic = totalPlanes / (double) dayNum;
		return averageTraffic;
	}

	/**
	 * Helper function to calculate Average ProhibitedItems
	 * @param itemCount
	 * @param dayNumber
	 * @return
	 */
	public double calculateProhibitedItems(int itemCount, int dayNumber) {
		averageProhibitedItems = (itemCount / (double) dayNumber);
		return averageProhibitedItems;
	}

	/**
	 * Helper function to return days, item count, average traffic, 
	 * avg prohibited items and total passengers
	 * @param cf
	 * @param line
	 * @return
	 */
	public computeFactors returnFactors(computeFactors cf, String line) {
		String[] split_string = line.split(";");
		cf.setTempDayNumber(Integer.parseInt(split_string[0].split(":")[1]));
		int tempPI = cf.getProhibitedItemCount();
		ArrayList<String> probI = new ArrayList<String>();
		probI.add("Gun");
		probI.add("Knife");
		probI.add("Blade");
		probI.add("NailCutter");
		if (probI.contains(split_string[3].split(":")[1])) {
			tempPI = tempPI + 1;
		}
		cf.setProhibitedItemCount(tempPI);
		cf.setTotalPlanes(cf.getTotalPlanes() + 1);
		cf.setAverageTraffic(calulateAverageTraffic(cf.getTempDayNumber(), cf.getTotalPlanes()));
		cf.setAverageProhibitedItems(calculateProhibitedItems(cf.getProhibitedItemCount(), cf.getTempDayNumber()));
		return cf;
	}

}
