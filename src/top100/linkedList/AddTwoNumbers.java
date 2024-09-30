package top100.linkedList;

import com.chenjian.cn.util.ListNode;
import com.chenjian.cn.util.ListNodeUtil;

import java.math.BigDecimal;


/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2024/9/24 21:49
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null){
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            sb2.append(l2.val);
            l2 = l2.next;
        }

        sb1.reverse();
        sb2.reverse();

        BigDecimal num1 = new BigDecimal(sb1.toString());
        BigDecimal num2 = new BigDecimal(sb2.toString());

        BigDecimal num = num1.add(num2);

        String sb = String.valueOf(num);

        ListNode dump = new ListNode();
        ListNode res = dump;
        for (int i = sb.length()-1; i>=0; i--){
            ListNode tmp = new ListNode(sb.charAt(i)-'0');
            dump.next = tmp;
            dump = dump.next;
        }
        return res.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode dumpy = new ListNode();
        ListNode curry = dumpy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            if (l1 != null) carry += l1.val;
            if (l2 != null) carry += l2.val;
            curry = curry.next = new ListNode(carry%10);
            carry = carry/10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dumpy.next;

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2,4,3};
        int[] num2 = new int[]{5,6,4};



        ListNode l1 = ListNodeUtil.constructList(num1);
        ListNode l2 = ListNodeUtil.constructList(num2);
        ListNode res = addTwoNumbers(l1,l2);
        ListNodeUtil.print(res);
    }
}
