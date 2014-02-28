/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex;

/**
 *
 * @author TONGO
 */
public class VmMethod {
	final VmClass clazz;

	int flag;
	boolean isInstance;
	boolean isSynchronized;

	String name;
	String descriptor;

	int stackSize;
	int variableSize;
	byte[] byteCode;

	int[] exceptionPositions;
	String[] exceptionClasses;

	int registerCount;
	int incomingArgumentCount;
	int outgoingArgumentCount;
	
	int[] lowerCodes;
	int[] upperCodes;
	int[] codes;

	String[] strings;
	String[] types;

	String[] descriptors;

	String[] fieldClasses;
	String[] fieldTypes;
	String[] fieldNames;

	String[] methodClasses;
	String[] methodTypes;
	String[] methodNames;

	int[] exceptionStartAddresses;
	int[] exceptionEndAdresses;
	int[] exceptionHandlerIndexes;
	String[][] exceptionHandlerTypes;
	int[][] exceptionHandlerAddresses;

	VmMethod(final VmClass clazz) {
		this.clazz = clazz;
	}

	public String toString() {
		return clazz.name + "#" + name + descriptor;
	}

}
