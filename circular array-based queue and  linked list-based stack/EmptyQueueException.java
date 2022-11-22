package question2;

/**
 *  class for throwing the exception if the list is empty
 * @author Lakhveer Singh
 *
 */
public class EmptyQueueException extends Exception {
	public EmptyQueueException(String str) {
		super(str);
	}
}