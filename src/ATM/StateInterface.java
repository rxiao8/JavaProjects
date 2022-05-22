package ATM;

/**
 * Interface implemented by all state objects
 * 
 * @author Rozie
 */
public interface StateInterface {
	/** Method to transition from one state to another */
	void update();

	/** Returns the state name */
	String getStateName();
}
