package com.jbergin.robot;

/** Exception thrown by robots when they encounter errors
 * @author jbergin
 *
 */
public class RobotException extends RuntimeException {

//	public RobotException() {
//		super();
//	}

	public RobotException(String message) {
		super(message);
	}

	public RobotException(Throwable cause) {
		super(cause);
	}

	public RobotException(String message, Throwable cause) {
		super(message, cause);
	}

}
