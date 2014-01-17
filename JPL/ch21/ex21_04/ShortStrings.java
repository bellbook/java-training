package ch21.ex21_04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String> {

    // 拡張すべきではない
    // フィールド strings が protected でないため

    private ListIterator<String> strings; // 元の文字列
    private final int maxLen; // この長さ以下の文字列だけを

    public ShortStrings(ListIterator<String> strings, int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
    }

    @Override
    public boolean hasNext() {
        String nextShort;
        int count = 0;
        while (strings.hasNext()) {
            count++;
            nextShort = strings.next();
            if (nextShort.length() <= maxLen) {
                back(count);
                return true;
            }
        }
        back(count);
        return false;
    }

    @Override
    public String next() {
        String nextShort;
        while (strings.hasNext()) {
            nextShort = strings.next();
            if (nextShort.length() <= maxLen) {
                return nextShort;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(String e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasPrevious() {
        String previousShort;
        int count = 0;
        while (strings.hasPrevious()) {
            count++;
            previousShort = strings.previous();
            if (previousShort.length() <= maxLen) {
                go(count);
                return true;
            }
        }
        go(count);
        return false;
    }

    @Override
    public int nextIndex() {
        int index = strings.nextIndex() - 1;

        String nextShort;
        int count = 0;
        while (strings.hasNext()) {
            count++;
            nextShort = strings.next();
            if (nextShort.length() <= maxLen) {
                back(count);
                return index + count;
            }
        }
        back(count);
        return index + count + 1;
    }

    @Override
    public String previous() {
        String previousShort;
        while (strings.hasPrevious()) {
            previousShort = strings.previous();
            if (previousShort.length() <= maxLen) {
                return previousShort;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public int previousIndex() {
        int index = strings.previousIndex() + 1;

        String previousShort;
        int count = 0;
        while (strings.hasPrevious()) {
            count++;
            previousShort = strings.previous();
            if (previousShort.length() <= maxLen) {
                go(count);
                return index - count;
            }
        }
        go(count);
        return index - count - 1;
    }

    @Override
    public void set(String e) {
        throw new UnsupportedOperationException();
    }

    private void go(int count) {
        for (int i = 0; i < count; i++)
            strings.next();
    }

    private void back(int count) {
        for (int i = 0; i < count; i++)
            strings.previous();
    }

}
