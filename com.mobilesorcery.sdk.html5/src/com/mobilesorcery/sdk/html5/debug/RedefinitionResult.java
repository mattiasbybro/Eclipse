package com.mobilesorcery.sdk.html5.debug;

public class RedefinitionResult {

	public static final int REDEFINE_OK = 0;
	public static final int CANNOT_REDEFINE = 1 << 2;
	public static final int CANNOT_RESTART = 1 << 1;
	
	private static final RedefinitionResult OK_INSTANCE = new RedefinitionResult(REDEFINE_OK, "OK");

	private int flags;
	private String msg;

	private RedefinitionResult() {
		
	}
	
	public RedefinitionResult(int flags, String msg) {
		this.flags = flags;
		this.msg = msg;
	}
	
	public boolean isFlagSet(int flag) {
		return (this.flags & flag) != 0;
	}
	
	public static RedefinitionResult ok() {
		return OK_INSTANCE;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public static boolean isOk(RedefinitionResult result) {
		return result.flags == REDEFINE_OK;
	}

	public static RedefinitionResult fail(String msg) {
		return new RedefinitionResult(CANNOT_REDEFINE | CANNOT_RESTART, msg);
	}
	
	public RedefinitionResult merge(RedefinitionResult other) {
		RedefinitionResult result = new RedefinitionResult();
		// We may need to change this logic once we get more flags!
		result.flags = this.flags | other.flags;
		result.msg = this.flags > other.flags ? this.msg : other.msg;
		return result;
	}

}