package dzseminar5;

import java.util.*;

public class zadacha2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ivan Petron");
        list.add("Svetlana Kolonina");
        list.add("Kristina Reznicov");
        list.add("Anna VAsga");
        list.add("Anna Sun");
        list.add("Ivan Sivockin");
        list.add("Petr Ivanov");
        list.add("Pavel Voda");
        list.add("Petr Petrov");
        list.add("Mary Kuri");
        list.add("Marina Napoleon");
        list.add("Mary Luzi");
        list.add("Mary Verdu");
        list.add("Marina Cvetaeva");
        list.add("Anna Severova");
        list.add("Ivan Join");
        list.add("Petr Petu");
        list.add("Ivan Vizit");

        showNames(list);

    }

    static Map<Integer,List<String>> getMap(List<String> list){
        Map<Integer,List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            String[] fi = list.get(i).split(" ");
            if (isName(map,fi[0])){
                int key = getKey(map,fi[0]);
                map.get(key).remove(fi[0]);
                if (map.containsKey(++key)){
                    map.get(key).add(fi[0]);
                } else {
                    List<String> names = new ArrayList<>();
                    names.add(fi[0]);
                    map.put(key, names);
                }
            } else {
                if(map.isEmpty()){
                    List<String> names = new ArrayList<>();
                    names.add(fi[0]);
                    map.put(1, names);
                } else {
                    map.get(1).add(fi[0]);
                }
            }
        }
        return map;
    }

    static boolean isName (Map<Integer,List<String>> map, String name){
        for(int x: map.keySet()){
            if(map.get(x).contains(name)){
                return true;
            }
        }
        return false;
    }

    static int getKey (Map<Integer,List<String>> map, String name){
        for (Map.Entry<Integer,List<String>> entry: map.entrySet()){
            if (entry.getValue().contains(name)){
                return entry.getKey();
            }
        }
        return 0;
    }

    static void showNames(List<String> list){
        Map<Integer,List<String>> map = getMap(list);
        for (Map.Entry<Integer,List<String>> entry: map.entrySet()){
            if(entry.getKey() > 1)
                System.out.println(entry.getValue().toString() + " repeat " +
                        entry.getKey() + " times\n");
        }
    }
}