/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex;

/**
 *
 * @author TONGO
 */
public class VmField {
	final VmClass clazz;
	
	int flag;
	boolean isInstance;

	String name;
	String type;

	int intValue;
	long longValue;
	Object objectValue;
	
	VmField(final VmClass clazz) {
		this.clazz = clazz;
	}

	public String toString() {
		String value;
		switch (type.charAt(0)) {
			case 'C':
				value = (char)intValue + " (char)";
				break;
			case 'B':
				value = (byte)intValue + " (byte)";
				break;
			case 'S':
				value = (short)intValue + " (short)";
				break;
			case 'I':
				value = intValue + " (int)";
				break;
			case 'Z':
				value = (intValue != 0) + " (boolean)";
				break;
			case 'J':
				value = longValue + " (long)";
				break;
			case 'L':
				value = objectValue + " (" + type.substring(1, type.length() -1) + ")";
				break;
			case '[':
				value = objectValue + " (" + type + ")";
				break;
			default:
				throw new VirtualMachineException("not supported field type: " + type);
		}
		return clazz.name + "." + name + " = " + value;
	}

	VmField copy() {
		VmField copy = new VmField(clazz);
		copy.flag = flag;
		copy.name = name;
		copy.type = type;
		copy.intValue = intValue;
		copy.longValue = longValue;
		copy.objectValue = objectValue;
		return copy;
	}

}
