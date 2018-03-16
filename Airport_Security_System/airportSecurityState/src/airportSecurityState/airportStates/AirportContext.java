package airportSecurityState;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger.DebugLevel;

public class AirportContext {

	private AirportStateI Low_Risk;
	private AirportStateI Moderate_RiskS;
	private AirportStateI High_Risk;
	private AirportStateI Current_State;
	private Results results;

	private computeFactors computeFactors = new computeFactors();

	public void lineProcessing(String fileLine) {
		computeFactors = Current_State.tightenOrLoosenSecurity(computeFactors, fileLine);
	}

	/**
	 * @return the results
	 */
	public Results getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(Results results) {
		this.results = results;
	}

	/**
	 * 
	 */
	public AirportContext(Results res) {
			setResults(res);
		Low_Risk = new Low_RiskState(this);
		Moderate_RiskS = new Moderate_RiskState(this);
		High_Risk = new High_RiskState(this);
		setCurrent_State(Low_Risk);
		MyLogger.writeMessage("AirportContext Contructor", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return the current_State
	 */
	public AirportStateI getCurrent_State() {
		return Current_State;
	}

	/**
	 * @param current_State
	 *            the current_State to set
	 */
	public void setCurrent_State(AirportStateI current_State) {
		Current_State = current_State;
	}

	/**
	 * @return the low_Risk
	 */
	public AirportStateI getLow_Risk() {
		return Low_Risk;
	}

	/**
	 * @param low_Risk
	 *            the low_Risk to set
	 */
	public void setLow_Risk(AirportStateI low_Risk) {
		Low_Risk = low_Risk;
	}

	/**
	 * @return the moderate_RiskS
	 */
	public AirportStateI getModerate_RiskS() {
		return Moderate_RiskS;
	}

	/**
	 * @param moderate_RiskS
	 *            the moderate_RiskS to set
	 */
	public void setModerate_RiskS(AirportStateI moderate_RiskS) {
		Moderate_RiskS = moderate_RiskS;
	}

	/**
	 * @return the high_Risk
	 */
	public AirportStateI getHigh_Risk() {
		return High_Risk;
	}

	/**
	 * @param high_Risk
	 *            the high_Risk to set
	 */
	public void setHigh_Risk(AirportStateI high_Risk) {
		High_Risk = high_Risk;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AirportContext [Low_Risk=" + Low_Risk + ", Moderate_RiskS=" + Moderate_RiskS + ", High_Risk="
				+ High_Risk + ", Current_State=" + Current_State + ", results=" + results + ", computeFactors="
				+ computeFactors + "]";
	}
}
