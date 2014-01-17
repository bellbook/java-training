package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Reflection {

    private Reflection() {
    }

    /**
     * クラスの引数なしコンストラクタを呼び出し、 インスタンスを生成する。
     *
     * @param className クラス名
     * @return インスタンス
     * @throws Throwable 呼び出したコンストラクタで例外が発生した場合、その例外をスローする
     */
    public static <T> T newInstance(String className) throws Throwable {
        return newInstance(className, null);
    }

    /**
     * クラスの引数ありコンストラクタを呼び出し、 インスタンスを生成する。
     *
     * @param className クラス名
     * @param types 引数の型となるクラス
     * @param args 引数の値
     * @return インスタンス
     * @throws Throwable 呼び出したコンストラクタで例外が発生した場合、その例外をスローする
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String className, Class<?>[] types,
            Object... args) throws Throwable {

        Class<T> c = null;
        try {
            c = (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Constructor<T> constructor = null;
        try {
            constructor = c.getConstructor(types);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {
            return constructor.newInstance(args);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * オブジェクトからフィールドを取得する。
     * @param obj フィールドを持つオブジェクト
     * @param name フィールド名
     * @return フィールド値
     */
    @SuppressWarnings("unchecked")
    public static <T> T getField(Object obj, String name) {

        Class<? extends Object> c = obj.getClass();
        Field f = null;

        try {
            f = c.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }

        f.setAccessible(true);

        try {
            return (T) f.get(obj);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * オブジェクトからフィールドを取得する。
     *
     * @param obj フィールドを持つオブジェクト
     * @param name フィールド名
     * @param value セットする値
     */
    public static void setField(Object obj, String name, Object value) {

        Class<? extends Object> c = obj.getClass();
        Field f = null;

        try {
            f = c.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }

        f.setAccessible(true);

        try {
            f.set(obj, value);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * オブジェクトから引数なしのメソッドを呼び出す。
     *
     * @param obj メソッドを持つオブジェクト
     * @param name メソッド名
     * @return メソッドの戻り値
     * @throws Throwable 呼び出したメソッドで例外が発生した場合、その例外をスローする
     */
    public static <T> T invoke(Object obj, String name) throws Throwable {
        return invoke(obj, name, null);
    }

    /**
     * オブジェクトから引数ありのメソッドを呼び出す。
     *
     * @param obj メソッドを持つオブジェクト
     * @param name メソッド名
     * @param types 引数の型となるクラス
     * @param args 引数の値
     * @return メソッドの戻り値
     * @throws Throwable 呼び出したメソッドで例外が発生した場合、その例外をスローする
     */
    @SuppressWarnings("unchecked")
    public static <T> T invoke(Object obj, String name, Class<?>[] types,
            Object... args) throws Throwable {

        Class<? extends Object> c = obj.getClass();
        Method m = null;

        try {
            m = c.getMethod(name, types);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }

        m.setAccessible(true);

        try {
            return (T) m.invoke(obj, args);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /**
     * 指定されたコンポーネント型と大きさで新しい配列を作成する。
     *
     * @param className クラス名
     * @param dimensions 新しい配列の次元数を表す int の配列
     */
    @SuppressWarnings("unchecked")
    public static <T> T newArray(String className, int... dimensions) {

        Class<?> componentType;
        try {
            componentType = Class.forName(className);
            return (T) Array.newInstance(componentType, dimensions);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 指定された配列オブジェクトのインデックス付きコンポーネントの値を、 指定された新しい値に設定する。
     *
     * @param array メッセージデータの長さ
     * @param index 配列の中のインデックス
     * @param value 指定されたインデックスのコンポーネントの新しい値
     */
    public static void setArray(Object array, int index, Object value) {

        try {
            Array.set(array, index, value);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 指定された配列オブジェクトの指定されたインデックスのコンポーネント値を返す。
     *
     * @param array メッセージデータの長さ
     * @param index インデックス
     * @return 指定された配列の指定されたインデックスのコンポーネント値
     */
    @SuppressWarnings("unchecked")
    public static <T> T getArray(Object array, int index) {

        try {
            return (T) Array.get(array, index);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

}
