package com.my.buch.touristagency.model.entity;

public class Discount {
	/** step of increasing*/
	private static int step;
	
	/** max value of discount */
	private static int max;
	
	private static Discount instance;
	
	/**
	 * The instantiates of new discount
	 */
	private Discount() {	
	}
	
	public synchronized static Discount getInstance() {
		if (instance == null) {
			instance = new Discount();
		}
		return instance;
	}
	/**
     * Gets the step.
     *
     * @return the step
     */
	public static int getStep() {
		return step;
	}

	/**
     * Sets the step.
     *
     * @param id the new step
     */
	public void setStep(int step) {
		Discount.step = step;
	}

	/**
     * Gets the max.
     *
     * @return the max
     */
	public static int getMax() {
		return max;
	}

	/**
     * Sets the max.
     *
     * @param id the new max
     */
	public void setMax(int max) {
		Discount.max = max;
	}
}
