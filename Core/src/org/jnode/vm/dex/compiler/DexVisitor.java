/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jnode.vm.dex.compiler;

/**
 *
 * author TONGO
 */
public abstract class DexVisitor {

    public abstract void setParser(DexParser parser);

    public abstract void visit_nop();

    public abstract void visit_move();

    public abstract void visit_move_16();
    
    public abstract void visit_move_wide_from16();
    
     public abstract void visit_move_wide_16();

    public abstract void visit_move_from16();

    public abstract void visit_move_wide();

    public abstract void visit_movewide_from16();

    public abstract void visit_move_object();

    public abstract void visit_move_object_from16();

    public abstract void visit_move_result();

    public abstract void visit_move_result_wide();

    public abstract void visit_moveresult_object();

    public abstract void visit_return_void();

    public abstract void visit_return();

    public abstract void visit_return_wide();

    public abstract void visit_return_object();

    public abstract void visit_throw();

    public abstract void visit_move_exception();

    public abstract void visit_const_4();

    public abstract void visit_const_16();

    public abstract void visit_const();

    public abstract void visit_const_high16();

    public abstract void visit_constwide_16();

    public abstract void visit_const_wide_32();

    public abstract void visit_const_wide();

    public abstract void visit_const_wide_high16();

    public abstract void visit_const_string();

    public abstract void visit_constclass();

    public abstract void visit_monitor_enter();

    public abstract void visit_monitor_exit();

    public abstract void visit_check_cast();

    public abstract void visit_instance_of();

    public abstract void visit_new_array();

    public abstract void visit_array_length();

    public abstract void visit_filled_new_array();

    public abstract void visit_filled_newarray_range();

    public abstract void visit_fill_array_data();

    public abstract void visit_new_instance();

    public abstract void visit_Goto();

    public abstract void visit_goto_16();

    public abstract void visit_packed_switch();

    public abstract void visit_sparse_switch();

    public abstract void visit_if_eq();

    public abstract void visit_if_ne();

    public abstract void visit_if_lt();

    public abstract void visit_if_ge();

    public abstract void visit_if_gt();

    public abstract void visit_if_le();

    public abstract void visit_if_eqz();

    public abstract void visit_if_nez();

    public abstract void visit_if_ltz();

    public abstract void visit_if_gez();

    public abstract void visit_if_gtz();

    public abstract void visit_if_lez();

    public abstract void visit_cmpl_float();

    public abstract void visit_cmpg_float();

    public abstract void visit_cmpl_double();

    public abstract void visit_cmpg_double();

    public abstract void visit_cmp_long();

    public abstract void visit_Iget();

    public abstract void visit_iget_wide();

    public abstract void visit_iget_object();

    public abstract void visit_iget_boolean();

    public abstract void visit_iget_byte();

    public abstract void visit_iget_char();

    public abstract void visit_iget_short();

    public abstract void visit_iput();

    public abstract void visit_iput_wide();

    public abstract void visit_iput_object();

    public abstract void visit_iput_boolean();

    public abstract void visit_iput_byte();

    public abstract void visit_iputchar();

    public abstract void visit_iput_short();

    public abstract void visit_aget();

    public abstract void visit_aget_wide();

    public abstract void visit_aget_object();

    public abstract void visit_aget_boolean();

    public abstract void visit_agetbyte();

    public abstract void visit_aget_char();

    public abstract void visit_aget_short();

    public abstract void visit_aput();

    public abstract void visit_aput_wide();

    public abstract void visit_aput_object();

    public abstract void visit_aput_boolean();

    public abstract void visit_aputbyte();

    public abstract void visit_aput_char();

    public abstract void visit_aput_short();

    public abstract void visit_sget();

    public abstract void visit_sget_wide();

    public abstract void visit_sget_object();

    public abstract void visit_sget_boolean();

    public abstract void visit_sgetbyte();

    public abstract void visit_sget_char();

    public abstract void visit_sget_short();

    public abstract void visit_sput();

    public abstract void visit_sput_wide();

    public abstract void visit_sput_object();

    public abstract void visit_sput_boolean();

    public abstract void visit_sputbyte();

    public abstract void visit_sput_char();

    public abstract void visit_sput_short();

    public abstract void visit_invoke_virtual();

    public abstract void visit_invoke_super();

    public abstract void visit_invoke_direct();

    public abstract void visit_invoke_static();

    public abstract void visit_invoke_interface();

    public abstract void visit_invoke_virtual_range();

    public abstract void visit_invoke_super_range();

    public abstract void visit_invokedirect_range();

    public abstract void visit_invoke_static_range();

    public abstract void visit_invoke_interface_range();

    public abstract void visit_Add();

    public abstract void visit_Sub();

    public abstract void visit_Mul();

    public abstract void visit_Div();

    public abstract void visit_Rem();

    public abstract void visit_And();

    public abstract void visit_Or();

    public abstract void visit_xor();

    public abstract void visit_shl();

    public abstract void visit_shr();

    public abstract void visit_ushr();

    public abstract void visit_neg_int();

    public abstract void visit_neg_long();

    public abstract void visit_neg_float();

    public abstract void visit_neg_double();

    public abstract void visit_neg_not_int();

    public abstract void visit_neg_not_long();

    public abstract void visit_execute_inline();

    public abstract void visit_invoke_direct_empty();

    public abstract void visit_iget_quick();

    public abstract void visit_iget_widequick();

    public abstract void visit_iget_object_quick();

    public abstract void visit_iput_quick();

    public abstract void visit_iput_wide_quick();

    public abstract void visit_iput_object_quick();

    public abstract void visit_invokevirtual_quick();

    public abstract void visit_invoke_virtual_quick_range();

    public abstract void visit_invoke_super_quick();

    public abstract void visit_invoke_superquick();

    public abstract void visit_range();
}
