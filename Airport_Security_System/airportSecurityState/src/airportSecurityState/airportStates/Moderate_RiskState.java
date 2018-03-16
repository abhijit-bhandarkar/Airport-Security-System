package airportSecurityState;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Moderate_RiskState implements AirportStateI {
	private AirportContext newContext;

	public Moderate_RiskState(AirportContext moderateContext) {
		newContext = moderateContext;
	}

	@Override
	public computeFactors tightenOrLoosenSecurity(computeFactors cf, String inputline) {

		computeFactors newValue = cf;
		newValue = newValue.returnFactors(cf, inputline);
		int risk = 1;
		//To decide the state of the airport
		if ((newValue.getAverageTraffic() >= 0) && (newValue.getAverageTraffic() < 4)
				|| (newValue.getAverageProhibitedItems() >= 0) && (newValue.getAverageProhibitedItems() < 1)) {

			newContext.setCurrent_State(newContext.getLow_Risk());
			risk = 1;
			MyLogger.writeMessage("State Changed to Low Risk State", DebugLevel.STATE_CHANGE);
		}

		if ((newValue.getAverageTraffic() >= 4 && newValue.getAverageTraffic() < 8)
				|| (1 <= newValue.getAverageProhibitedItems() && newValue.getAverageProhibitedItems() < 2)) {
			newContext.setCurrent_State(newContext.getModerate_RiskS());
			risk = 2;
			MyLogger.writeMessage("State Changed to Moderate Risk State", DebugLevel.STATE_CHANGE);
		}

		if (newValue.getAverageTraffic() >= 8 || newValue.getAverageProhibitedItems() >= 2) {
			newContext.setCurrent_State(newContext.getHigh_Risk());
			risk = 3;
			MyLogger.writeMessage("State Changed to High Risk State", DebugLevel.STATE_CHANGE);
		}
		//To print the expected values in the output file
		Results r = newContext.getResults();
		if (risk == 1) {
			r.writeToFile("1 3 5 7 9");
			MyLogger.writeMessage("Low Risk Operation Performed : 1 3 5 7 9", DebugLevel.OPERATION_PERFORMED);
		} else if (risk == 2) {
			r.writeToFile("2 3 5 8 9");
			MyLogger.writeMessage("Moderate Risk Operation Performed : 2 3 5 8 9", DebugLevel.OPERATION_PERFORMED);
		} else {
			r.writeToFile("2 4 6 8 10");
			MyLogger.writeMessage("High Risk Operation Performed : 2 4 6 8 10", DebugLevel.OPERATION_PERFORMED);
		}
		return newValue;
	}
}
