/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex.compiler.x86;

import org.jnode.assembler.x86.X86Assembler;
import org.jnode.vm.dex.VmMethod;
import org.jnode.vm.dex.VmClassLoader;
import org.jnode.vm.dex.compiler.DexParser;
import org.jnode.vm.dex.compiler.DexVisitor;

/**
 *
 * @author TONGO Actual converter from Dex to x86 binary
 */
public class X86DexVisitor extends DexVisitor {

    /**
     * The output stream
     */
    private X86Assembler os;
    /**
     * The method currently being compiled
     */
    private VmMethod currentMethod;
    /**
     * Class loader
     */
    private VmClassLoader loader;

    //private DexParser parser;
    @Override
    public void setParser(DexParser parser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * No operaation
     */
    @Override
    public void visit_nop() {
        os.writeNOP();
    }

    /**
     * for move, move-object, long-to-int 
     * op vA, vB
     * A: destination register (4 bits)
     * B: source register (4 bits)
     */
    @Override
    public void visit_move() {
        //
    }

    @Override
    public void visit_move_from16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_move_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_movewide_from16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_move_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_move_object_from16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_move_result() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_move_result_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_moveresult_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_return_void() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_return() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_return_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_return_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_throw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_move_exception() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_4() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_high16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_constwide_16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_wide_32() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_wide_high16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_const_string() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_constclass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_monitor_enter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_monitor_exit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_check_cast() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_instance_of() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_new_array() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_array_length() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_filled_new_array() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_filled_newarray_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_fill_array_data() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_new_instance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Goto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_goto_16() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_packed_switch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sparse_switch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_eq() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_ne() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_lt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_ge() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_gt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_le() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_eqz() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_nez() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_ltz() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_gez() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_gtz() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_if_lez() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_cmpl_float() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_cmpg_float() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_cmpl_double() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_cmpg_double() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_cmp_long() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Iget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_boolean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_byte() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_char() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_short() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_boolean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_byte() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iputchar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_short() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aget_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aget_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aget_boolean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_agetbyte() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aget_char() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aget_short() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aput_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aput_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aput_boolean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aputbyte() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aput_char() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_aput_short() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sget_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sget_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sget_boolean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sgetbyte() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sget_char() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sget_short() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sput_wide() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sput_object() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sput_boolean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sputbyte() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sput_char() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_sput_short() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_virtual() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_super() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_direct() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_static() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_interface() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_virtual_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_super_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invokedirect_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_static_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_interface_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Add() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Sub() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Mul() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Div() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Rem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_And() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_Or() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_xor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_shl() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_shr() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_ushr() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_neg_int() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_neg_long() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_neg_float() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_neg_double() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_neg_not_int() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_neg_not_long() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_execute_inline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_direct_empty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_widequick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iget_object_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_wide_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_iput_object_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invokevirtual_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_virtual_quick_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_super_quick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_invoke_superquick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit_range() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
