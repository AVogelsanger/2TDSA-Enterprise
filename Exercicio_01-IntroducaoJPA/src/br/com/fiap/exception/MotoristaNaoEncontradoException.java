package br.com.fiap.exception;

public class MotoristaNaoEncontradoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MotoristaNaoEncontradoException() {
		super();
		
	}

	public MotoristaNaoEncontradoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public MotoristaNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MotoristaNaoEncontradoException(String message) {
		super(message);
		
	}

	public MotoristaNaoEncontradoException(Throwable cause) {
		super(cause);
		
	}

}
