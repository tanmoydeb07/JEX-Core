/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex;

/**
 *
 * @author TONGO
 */
import java.util.Hashtable;

final class VmClass {
	final ClassLoader classLoader;

	int flag;
	boolean isInterface;
	String name;

	String superClass;
	String[] interfaces;

	VmField[] instanceFields;
	VmField[] staticFields;
	Hashtable staticFieldMap;

	VmMethod[] directMethods;
	VmMethod[] virtualMethods;

	boolean binded;

	VmClass(final ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public String toString() {
		return (isInterface ? "interface " : "class ") + getName();
	}

	VmMethod getVirtualMethod(final String name, final String descriptor) {
		VmClass current = this;
		do {
			VmMethod[] currentMethods = current.virtualMethods;
			for (int i = 0, length = currentMethods.length; i < length; i++) {
				VmMethod method = currentMethods[i];
				if (name.equals(method.name) && descriptor.equals(method.descriptor)) {
					return method;
				}
			}
			current = classLoader.loadClass(current.superClass);
		} while (current != null);
		return null;
	}

	VmMethod getDirectMethod(final String name, final String descriptor) {
		VmMethod[] currentMethods = directMethods;
		for (int i = 0, length = currentMethods.length; i < length; i++) {
			VmMethod method = currentMethods[i];
			if (name.equals(method.name) && descriptor.equals(method.descriptor)) {
				return method;
			}
		}
		return null;
	}

	VmField getStaticField(final String name) {
		return (VmField)staticFieldMap.get(name);
	}

	String getName() {
		return name.replace('/', '.');
	}
}

