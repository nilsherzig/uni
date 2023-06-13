package student;

import java.util.ArrayList;
import java.util.Collections;

public class MinMidMax<T extends Comparable<T>> {

    private ArrayList<T> list = new ArrayList<T>();

    @SafeVarargs
    public MinMidMax(T... objects) {
        for (T object : objects) {
            push(object);
        }
    }

    public boolean push(T object) {
        if (list.contains(object)) {
            return false;
            // throw new IllegalArgumentException("Object already in list");
        }
        list.add(object);
        Collections.sort(list);
        return true;
    }

    public T popRight() {
        if (list.isEmpty() || list.size() == 0) {
            return null;
        }
        T obj = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return obj;
    }

    public T popLeft() {
        if (list.isEmpty() || list.size() == 0) {
            return null;
        }
        T obj = list.get(0);
        list.remove(0);
        // Collections.sort(list);
        return obj;
    }

    public T getMinimum() {
        if (list.isEmpty() || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public T getMaximum() {
        if (list.isEmpty() || list.size() == 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public T getMid() {
        if (list.isEmpty() || list.size() == 0) {
            return null;
        }
        if (list.size() % 2 == 0) {
            return list.get(list.size() / 2);
        }
        return list.get(list.size() / 2);
    }

    public int getNumItems() {
        return list.size(); 
    }

    public ArrayList<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        sb.append("[");
        for (int index = 0; index < list.size(); index++) {
            sb.append(list.get(index).toString());
            if (index < list.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
