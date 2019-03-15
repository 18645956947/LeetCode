package List; 

/** 
* @author lenovo
* @date 2019��3��15������11:13:58 
* @Description: 147. ��������в�������
*/
//147. ��������в�������
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // ���������ǵ����ģ�ÿ��ֻ�ƶ�һ��Ԫ�أ�ֱ������Ԫ�ؿ����γ�һ�����������б�
        // ÿ�ε����У���������ֻ�������������Ƴ�һ���������Ԫ�أ��ҵ������������ʵ���λ�ã���������롣
        // ÿ�ε�����ɣ��Ӳ���Ԫ��Ϊֹ����������Ա���Ϊ�Ѿ���������
        // �ظ�ֱ�������������ݲ�����Ϊֹ
        
         // 1.��������ǰ���Ѿ������������ǰ��һ�Ƚ������ҵ�����Ϊֹ����
        
        // ��������ָ�� pre, cur, lat
        //pre    cur    lat
        // h  ->  4  ->  2  ->  5  ->  3  ->  null
        
        // ���� h �ڵ㣬���ڱ�������
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        ListNode lat;
        
        while (cur != null) {
            lat = cur.next; // ��¼��һ��Ҫ���������ֵ
            
            if (lat != null && lat.val < cur.val) { // ֻ�� cur.next �� cur С����Ҫ��ǰѰ�Ҳ����
                // Ѱ�Ҳ���㣬�� pre ��ʼ���� ��ÿ�ζ���ͷ�ڵ� h ��ʼ����������Ϊ�����������޷��Ӻ���ǰ�飩
                while (pre.next != null && pre.next.val < lat.val) { // �����ǰ�ڵ��ֵС��Ҫ���������ֵ
                    pre = pre.next; // ��������ƶ�
                }
                
                // �ҵ�Ҫ�����λ�ã���ʱ pre �ڵ�����λ�þ��� lat Ҫ�����λ��
                // ���� pre �� lat �ڵ���Ҫһ�� temp �ڵ�����ʱ�����²���λ�� node �� next
                ListNode tmp = pre.next;
                // �� pre �ڵ�������
                pre.next = lat;
                // ��ʱ cur �ڵ㻹�� pre ���ڵĽڵ㣬������ next Ҫָ�����ڵ� lat ָ��� next
                cur.next = lat.next;
                // ����let�ڵ�󣬰Ѽ�¼��ԭ�Ȳ���λ�ú����� next �ڵ㴫����
                lat.next = tmp;
                // ����ÿ�ζ��Ǵ�ǰ�����Ҳ���λ�ã����ǵ����������޷��Ӻ���ǰ������������Ҫÿ�β�����ɺ�Ҫ�� pre ��λ
                pre = h;
            } else {
                // ����ֱ�Ӱ� cur ָ��ָ����һ��
                cur = lat;
            }
        }
        
       return h.next;
	}
}
 