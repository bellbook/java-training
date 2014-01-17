package ch22.ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BitSetMap {

    public static void main(String[] args) {
        BitSetMap wc = new BitSetMap("Testing 1 2 3");
        System.out.println(wc);
    }

    private Map<BitSet, Byte> map = new HashMap<BitSet, Byte>();

    public BitSetMap(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            byte high = (byte) (c & 0xFF00);
            BitSet bitSet = new BitSet();
            bitSet.set(c);
            map.put(bitSet, high);
        }
    }

    public String toString() {
        String desc = "[ ";

        for (Entry<BitSet, Byte> e : map.entrySet()) {
            BitSet key = e.getKey();
            Byte value = e.getValue();

            for (int i = key.nextSetBit(0); i >= 0; i = key.nextSetBit(i + 1)) {
                desc += "[key: '" + (char) i + "', value: " + value + "] ";
            }
        }
        return desc + "]";
    }

}
