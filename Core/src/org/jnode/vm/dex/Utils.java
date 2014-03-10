/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex;

/**
 *
 * @author TONGO
 */
final class Utils {
	static void setLong(final int[] ints, final int offset, final long value) {
		ints[offset] = (int)(value & 0xFFFFFFFF);
		ints[offset + 1] = (int)(value >>> 32);
	}

	static long getLong(final int[] ints, final int offset) {
		return (ints[offset] & 0xFFFFFFFFL) | ((long)ints[offset + 1] << 32);
	}

	static int toInt(final boolean value) {
		return value ? 1 : 0;
	}

	static String toClassName(final String type) {
		return type.substring(1, type.length() - 1);
	}
}
