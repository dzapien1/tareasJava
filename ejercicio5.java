public class ejercicio5 {

    static class Node {
        int id;
        Node next;

        Node(int id) {
            this.id = id;
            this.next = null;
        }
    }

    static class Sensor {
        Node head;

        public void addNode(int id) {
            Node newNode = new Node(id);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public boolean hasCycle() {
            if (head == null) return false;

            Node slow = head; 
            Node fast = head; 

            while (fast != null && fast.next != null) {
                
                slow = slow.next;       
                fast = fast.next.next;  

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Sensor sensores = new Sensor();

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        sensores.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("Caso 1: ¿Tiene ciclo? " + sensores.hasCycle() + "\n");

        //ciclo no nulo
        n4.next = n2; 

        System.out.println("Caso 2: ¿Tiene ciclo? " + sensores.hasCycle() + "\n");
    }
}