package ch20.ex20_10;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounter {

    private Map<String, Integer> map = new HashMap<String, Integer>();

    public WordCounter(Reader source) throws IOException {
        read(source);
    }

    private void read(Reader source) throws IOException {

        StreamTokenizer in = new StreamTokenizer(source);
        String word;
        Integer count;
        in.commentChar('#');
        in.ordinaryChar('/');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD) {
                word = in.sval;
                count = map.get(word);
                if (count == null)
                    map.put(word, 1);
                else
                    map.put(word, count + 1);
            }
        }
    }

    public void show() {
        for (Entry<String, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " : " + e.getValue() + " count");
    }

}
