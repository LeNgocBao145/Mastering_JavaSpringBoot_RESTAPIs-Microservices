class Bitwise {
    public static void main(String[] args) {
        int a = 5;  // Binary: 0101
        int b = 3;  // Binary: 0011
        System.out.println("a & b = " + (a & b)); // Bitwise AND
        System.out.println("a | b = " + (a | b)); // Bitwise OR
        System.out.println("a ^ b = " + (a ^ b)); // Bitwise XOR

        // (~a) = -(a + 1)
        System.out.println("~a = " + (~a));       // Bitwise NOT

        int c = -5;  // Binary: 1011
        System.out.println("a << 1 = " + (a << 1)); // Left shift
        System.out.println("a >> 1 = " + (a >> 1)); // Right shift
        System.out.println("c >>> 1 = " + (c >>> 1)); // Unsigned right shift
    }
}