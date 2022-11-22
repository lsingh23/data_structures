package question1;

/**
 *  class for throwing the exception if the list is empty
 * @author Lakhveer Singh
 *
 */
public class EmptyDequeException extends Exception {
	public EmptyDequeException(String str) {
		super(str);
	}
}
