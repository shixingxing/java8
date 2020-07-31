public class ByteTest {
    public static void main(String[] args) {
        byte[] data = new byte[]{0x11, 0x22};

        int sum = data[0] << 8 | data[1];
        System.out.println(sum);
    }
}
