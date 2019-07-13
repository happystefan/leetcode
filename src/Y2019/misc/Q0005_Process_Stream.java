package Y2019.misc;

public class Q0005_Process_Stream {

    String buffer = "";

    private void processData(byte[] data) {
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1
     *
     *------------------------------------------------------------------------------------------------------------------
     */
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

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public void onDataArrive_Recursive(byte[] chunk) {
        String str = new String(chunk);
        buffer += str;
        if (buffer.length() < 4) return;
        int len = Integer.valueOf(buffer.substring(0, 5));
        if (4 + len > buffer.length()) return;
        byte[] data = str.substring(4, 4 + len).getBytes();
        processData(data);
        buffer = buffer.substring(4 + len);
        onDataArrive_Recursive("".getBytes());
    }

}
