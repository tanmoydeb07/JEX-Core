/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex.compiler;

import java.nio.ByteBuffer;
import org.jnode.vm.dex.VmMethod;

/**
 *
 * @author TONGO
 */
public class DexParser {
    private ByteBuffer bytecode;

    private final DexVisitor handler;

    private int address;

    private boolean wide;

    private int opcode;

    private int paddedAddress;

    private int continueAt;

    private int endPC;

    /**
     * @return The padded address
     */
    public final int getPaddedAddress() {
        return this.paddedAddress;
    }

    /**
     * Create a new instance
     *
     * @param bc
     * @param handler
     */
    protected DexParser(/*VmByteCode bc,*/ DexVisitor handler) {
        //this.bc = bc;
        //this.bytecode = bc.getBytecode();
        //this.cp = bc.getCP();
        this.handler = handler;
    }

    /**
     * Parse a given bytecode
     *
     * @param bc
     * @param handler
     * @throws ClassFormatError
     */
    public static void parse(VmByteCode bc, DexVisitor handler)
        throws ClassFormatError {
        new DexParser(bc, handler).parse();
    }

    /**
     * Parse a given bytecode
     *
     * @param bc
     * @param handler
     * @param startPC        The program counter where to start parsing (inclusive)
     * @param endPC          The program counter where to stop parsing (exclusive)
     * @param startEndMethod Should startMethod and endMethod be called.
     * @throws ClassFormatError
     */
    public static void parse(VmByteCode bc, DexVisitor handler,
                             int startPC, int endPC, boolean startEndMethod)
        throws ClassFormatError {
        new DexParser(bc, handler).parse(startPC, endPC, startEndMethod);
    }

    /**
     * Parse a given bytecode
     *
     * @throws ClassFormatError
     */
    public void parse() throws ClassFormatError {
        parse(0, bytecode.limit(), true);
    }

    /**
     * Parse a selected region of the bytecode
     *
     * @param startPC  The program counter where to start parsing (inclusive)
     * @param endPCArg The program counter where to stop parsing (exclusive)
     * @throws ClassFormatError
     */
    public void parse(int startPC, int endPCArg, boolean startEndMethod)
        throws ClassFormatError {

        final DexVisitor handler = this.handler;
        bytecode.position(startPC);
        this.endPC = endPCArg;
        handler.setParser(this);
        if (startEndMethod) {
            fireStartMethod(bc.getMethod());
        }

        while (bytecode.position() < endPC) {

            // The address(offset) of the current instruction
            this.continueAt = -1;
            this.address = bytecode.position();
            this.wide = false;
            fireStartInstruction(address);
            this.opcode = getu1();
            final int cpIdx;

            //counters[ opcode]++;
            switch (opcode) {
                case 0x00: //nope
                    handler.visit_nop();
                    break;
                case 0x01:
                    handler.visit_move();
                    break;
                case 0x02:
                    handler.visit_move_16();
                    break;
                case 0x03:
                    handler.visit_move_from16();
                    break;
                case 0x04:
                    handler.visit_move_wide();
                    break;
                case 0x05:
                    handler.visit_move_wide_from16();
                    break;
                case 0x06:
                    handler.visit_move_wide_16();
                    break;
                case 0x07:
                    handler.visit_move_object();
                    break;
                case 0x08:
                    handler.visit_move_object_from16();
                    break;
                case 0x09:
                    //handler.visit_move_object_16();
                    break;            
                
            }
        }
    }
        /**
     * Get an unsigned byte from the next bytecode position
     *
     * @return int
     */
    private final int getu1() {
        return bytecode.get() & 0xFF;
    }

    /**
     * Get an unsigned short from the next bytecode position
     *
     * @return int
     */
    private final int getu2() {
        int v1 = bytecode.get() & 0xFF;
        int v2 = bytecode.get() & 0xFF;
        return (v1 << 8) | v2;
    }

    /**
     * Get an unsigned int from the next bytecode position
     *
     * @return int
     */
    private final int getu4() {
        int v1 = bytecode.get() & 0xFF;
        int v2 = bytecode.get() & 0xFF;
        int v3 = bytecode.get() & 0xFF;
        int v4 = bytecode.get() & 0xFF;
        return (v1 << 24) | (v2 << 16) | (v3 << 8) | v4;
    }

    /**
     * Get a byte from the next bytecode position
     *
     * @return byte
     */
    private final byte gets1() {
        return bytecode.get();
    }

    /**
     * Get a short from the next bytecode positions
     *
     * @return short
     */
    private final short gets2() {
        int v1 = bytecode.get() & 0xFF;
        int v2 = bytecode.get() & 0xFF;
        return (short) ((v1 << 8) | v2);
    }

    /**
     * Get an int from the next bytecode position
     *
     * @return int
     */
    private final int gets4() {
        int v1 = bytecode.get() & 0xFF;
        int v2 = bytecode.get() & 0xFF;
        int v3 = bytecode.get() & 0xFF;
        int v4 = bytecode.get() & 0xFF;
        return (v1 << 24) | (v2 << 16) | (v3 << 8) | v4;
    }

    private final void skipPadding() {
        while (bytecode.position() % 4 != 0) {
            bytecode.get();
        }
        paddedAddress = bytecode.position();
    }

    private final void skip() {
        bytecode.get();
    }

    /**
     * Gets the address of the current instruction in the parse method.
     *
     * @return int
     */
    public final int getAddress() {
        return this.address;
    }

    /**
     * Gets the address of the next instruction in the parse method.
     *
     * @return int
     */
    public final int getNextAddress() {
        return bytecode.position();
    }

    /**
     * Is the current instruction a wide instruction
     *
     * @return boolean
     */
    public final boolean isWide() {
        return this.wide;
    }

    /**
     * Gets the opcode of the current instruction
     *
     * @return int
     */
    public final int getOpcode() {
        return this.opcode;
    }

    public final void setContinueAt(int offset) {
        continueAt = offset;
    }

    public final void setCode(ByteBuffer bytecode) {
        this.bytecode = bytecode;
    }

    public final void adjustEndPC(int delta) {
        endPC += delta;
    }

    public final void setEndPC(int offset) {
        endPC = offset;
    }

    /**
     * @return The end PC of the parsable block
     */
    public int getEndPC() {
        return this.endPC;
    }

    /**
     * Call the startInstruction method of the handler.
     *
     * @param address
     */
    protected void fireStartInstruction(int address) {
        handler.startInstruction(address);
    }

    /**
     * Call the endInstruction method of the handler.
     */
    protected void fireEndInstruction() {
        handler.endInstruction();
    }

    /**
     * Call the startInstruction method of the handler.
     *
     * @param method
     */
    protected void fireStartMethod(VmMethod method) {
        handler.startMethod(method);
    }

    /**
     * Call the endMethod method of the handler.
     */
    protected void fireEndMethod() {
        handler.endMethod();
    }

        
}
