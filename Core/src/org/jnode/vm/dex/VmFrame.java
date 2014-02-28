/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex;

/**
 *
 * @author TONGO
 */
public final class VmFrame {
	private static final int DEFAULT_REGISTER_SIZE = 16;

	final Thread thread;

	VmMethod method;
	boolean isChangeThreadFrame;

	int pc;

	int registerCount;
	boolean[] isObjectRegister = new boolean[DEFAULT_REGISTER_SIZE];
	int[] intRegisters = new int[DEFAULT_REGISTER_SIZE];
	Object[] objectRegisters = new Object[DEFAULT_REGISTER_SIZE];

	int argumentCount;
	public int[] intArguments = new int[DEFAULT_REGISTER_SIZE];
	public Object[] objectArguments = new Object[DEFAULT_REGISTER_SIZE];

	public int singleReturn;
	public long doubleReturn;
	public Object objectReturn;
	public Throwable throwableReturn;

	Object monitor;

	VmFrame(final Thread thread) {
		this.thread = thread;
	}

	public String toString() {
		return method.clazz.getName() + "." + method.name + method.descriptor;
	}

	// Don't implement the initialization of this class in the constructor to re-use this instance
	void init(final Method method) {
		init(method, false);
	}

	// Don't implement the initialization of this class in the constructor to re-use this instance
	void init(final VmMethod method, final boolean isChangeThreadFrame) {
		this.method = method;
		this.isChangeThreadFrame = isChangeThreadFrame;

		pc = 0;

		int newRegisterCount = method.registerCount;
		this.registerCount = newRegisterCount;
		if (intRegisters.length < newRegisterCount) {
			isObjectRegister = new boolean[newRegisterCount];
			intRegisters = new int[newRegisterCount];
			objectRegisters = new Object[newRegisterCount];
		}

		int newArgumentCount = method.outgoingArgumentCount;
		this.argumentCount = newArgumentCount;
		if (intArguments.length < newArgumentCount) {
			intArguments = new int[newArgumentCount];
			objectArguments = new Object[newArgumentCount];
		}
	}

	void setArgument(final int index, final int value) {
		intArguments[index] = value;
	}

	void setArgument(final int index, final long value) {
		Utils.setLong(intArguments, index, value);
	}

	void setArgument(final int index, final Object value) {
		objectArguments[index] = value;
	}

	// This method is used to set arguments before calling
	void intArgument(final int index, final Object value) {
		objectRegisters[registerCount - index - 1] = value;
	}

	void destroy() {
		for (int i = 0, length = registerCount; i < length; i++) {
			isObjectRegister[i] = false;
			intRegisters[i] = 0;
			objectRegisters[i] = null;
		}
		for (int i = 0, length = argumentCount; i < length; i++) {
			intArguments[i] = 0;
			objectArguments[i] = null;
		}
		singleReturn = 0;
		doubleReturn = 0;
		objectReturn = null;
		throwableReturn = null;

		if (method.isSynchronized) {
			Object monitor = this.monitor;
			this.monitor = null;
			thread.releaseLock(monitor);
		}
	}
}
