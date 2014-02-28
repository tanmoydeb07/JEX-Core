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

final class VmInstance {

    final VmClass clazz;
    Object parentInstance;
    private final Hashtable fieldsOfClasses = new Hashtable();

    VmInstance(final VmClass clazz) {
        this.clazz = clazz;

        VmClass current = clazz;
        do {
            Hashtable fields = new Hashtable();
            VmField[] currentFields = current.instanceFields;
            for (int i = 0, length = currentFields.length; i < length; i++) {
                VmField field = currentFields[i];
                fields.put(field.name, field.copy());
            }
            fieldsOfClasses.put(current.name, fields);
            current = current.classLoader.loadClass(current.superClass);
        } while (current != null);
    }

    public String toString() {
        return clazz.getName() + "@" + Integer.toHexString(hashCode());
    }

    VmField getField(final String className, final String fieldName) {
        String currentClassName = className;
        while (true) {
            Hashtable fields = (Hashtable) fieldsOfClasses.get(currentClassName);
            if (fields == null) {
                return null;
            }
            VmField field = (VmField) fields.get(fieldName);
            if (field != null) {
                return field;
            }
            VmClass currentClazz = clazz.classLoader.loadClass(currentClassName);
            if (currentClazz == null) {
                return null;
            }
            currentClassName = currentClazz.superClass;
        }
    }
}
