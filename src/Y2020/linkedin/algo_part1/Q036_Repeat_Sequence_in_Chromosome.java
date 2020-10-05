package Y2020.linkedin.algo_part1;

import java.io.Reader;
import java.util.*;

public class Q036_Repeat_Sequence_in_Chromosome {

    public List<String> getRepeatSequences(Reader chromosome, int seqLength) {
        Scanner scanner = new Scanner(chromosome);
        if(seqLength < 1) {
            throw new IllegalArgumentException();
        } else if (seqLength < 16) {
            return getRepeatSequences_bit(scanner, seqLength);
        } else {
            return getRepeatSequences_string(scanner, seqLength);
        }
    }

    private List<String> getRepeatSequences_string(Scanner scanner, int seqLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seqLength; i++) {
            if (scanner.hasNext()) {
                char c = (char) scanner.nextByte();
                sb.append(c);
            } else {
                return null;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put(sb.toString(), false);
        while (scanner.hasNext()) {
            char c = (char) scanner.nextByte();
            sb.deleteCharAt(0);
            sb.append(c);
            String str = sb.toString();
            if (!map.containsKey(str)) map.put(str, false);
            else map.put(str, true);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<String> rslt = new LinkedList<>();
        for (String key : keys) {
            if (map.get(key)) rslt.add(key);
        }
        return rslt;
    }

    private List<String> getRepeatSequences_bit(Scanner scanner, int seqLength) {
        final int mask = (1 << (seqLength * 2)) - 1;
        int seq = 0;
        for (int i = 0; i < seqLength; i++) {
            if (scanner.hasNext()) {
                char c = (char) scanner.nextByte();
                seq = shift(seq, c);
                seq &= mask;
            } else {
                return null;
            }
        }

        Map<Integer, Boolean> map = new HashMap<>();
        // another idea is  to allocate a arr[1 << (seqLength * 2)] to replace the map
        // pros: no need to sort
        // cons: if chromosome is like "AAAAA...AAAA", there will be lots of useless
        //       memory space get allocated
        map.put(seq, false); // false means only appear on time
        while (scanner.hasNext()) {
            char c = (char) scanner.nextByte();
            seq = shift(seq, c);
            seq &= mask;
            if (!map.containsKey(seq)) map.put(seq, false);
            else map.put(seq, true);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<String> rslt = new LinkedList<>();
        for (int key : keys) {
            if (map.get(key)) {
                rslt.add(decode(key, seqLength));
            }
        }
        return rslt;
    }

    private byte encode(char c) {
        return (byte) "ACGT".indexOf(c);
    }

    private String decode(int seq, int seqLen) {
        char[] ss = new char[seqLen];
        for (int i = seqLen - 1; i >= 0; i--) {
            ss[i] = "ACGT".charAt(seq & 0x11);
            seq >>= 2;
        }
        return String.valueOf(ss);
    }

    private int shift(int seq, char c) {
        return (seq << 2) | encode(c);
    }

}
