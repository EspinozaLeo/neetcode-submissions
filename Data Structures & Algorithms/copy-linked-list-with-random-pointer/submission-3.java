/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //two pass solution
        // Map<Node, Node> oldToCopy = new HashMap<>();
        // oldToCopy.put(null, null);

        // Node cur = head;
        // while(cur != null){
        //     Node copy = new Node(cur.val);
        //     oldToCopy.put(cur, copy);
        //     cur = cur.next;
        // }

        // cur = head;
        // while(cur != null){
        //     Node copy = oldToCopy.get(cur);
        //     copy.next = oldToCopy.get(cur.next);
        //     copy.random = oldToCopy.get(cur.random);
        //     cur = cur.next;
        // }

        // return oldToCopy.get(head);

        //O(1) memory solution
        if(head == null) return null;
        Node curr = head;
        //create copies and connect it next to original 1 -> 1' -> 2 -> 2' ...
        while(curr != null){
            Node temp = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = temp;
            curr = temp;
        }

        //connect copy node to its random counterpart
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //disconnect the copies from the original linked list
        curr = head;
        Node copyHead = curr.next;
        while(curr != null){
            Node copy = curr.next;
            curr.next = copy.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            curr = curr.next;
        }

        return copyHead;
    }
}