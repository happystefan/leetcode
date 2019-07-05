package Y2019.misc;

public class Q005_Process_Stream {

    private void processData(byte[] data) {
    }


    String buffer = "";

    // solution 1:
    public void onDataArrive(byte[] chunk) {
        String str = new String(chunk);
        buffer += str;
        while (buffer.length() >= 4 && Integer.valueOf(buffer.substring(0, 5)) <= buffer.length() - 4) {
            int len = Integer.valueOf(buffer.substring(0, 5));
            byte[] data = str.substring(4, 4 + len).getBytes();
            processData(data);
            buffer = buffer.substring(4 + len);
        }
    }

    // solution 2 (recursive):
    public void onDataArriveRecursive(byte[] chunk) {
        String str = new String(chunk);
        buffer += str;
        if (buffer.length() < 4) return;
        int len = Integer.valueOf(buffer.substring(0, 5));
        if (4 + len > buffer.length()) return;
        byte[] data = str.substring(4, 4 + len).getBytes();
        processData(data);
        buffer = buffer.substring(4 + len);
        onDataArriveRecursive("".getBytes());
    }

}
