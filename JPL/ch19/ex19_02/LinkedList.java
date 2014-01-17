package ch19.ex19_02;

public class LinkedList {

    /** リストが持つデータ */
    private Object data;

    /** 次のリストの参照 */
    private LinkedList next;

    /**
     * 指定されたデータと指定されたリストの参照を持つ 連結リストを生成する。
     *
     * @param data
     *            リストが持つデータ
     *
     * @param next
     *            次のリストの参照
     */
    public LinkedList(Object data, LinkedList next) {
        this.data = data;
        this.next = next;
    }

    /**
     * リストが持つデータを取得する。
     *
     * @return リストが持つデータ
     */
    public Object getData() {
        return data;
    }

    /**
     * リストが持つデータを設定する。
     *
     * @param data
     *            リストが持つデータ
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * リスト内にある要素の数を取得する。
     *
     * @return リスト内にある要素の数
     */
    public int getItemNum() {

        if (next == null)
            return 1;
        else
            return 1 + next.getItemNum();
    }

    @Override
    public String toString() {
        return "LinkedList [data=" + data + "]";
    }

    /**
     * リストが持つ全データの toString() を呼び出す。
     */
    public void print() {
        System.out.println(this);

        if (next != null) {
            next.print();
        }
    }

}
