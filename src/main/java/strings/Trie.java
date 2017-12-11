package strings;

import strings.utils.OurString;

public class Trie {

    private int c = 26;
    private Node trieRoot;

    private class Node {
        private Integer value;
        Node[] links = new Node[c];

        public Integer getValue() {
            return value;
        }
    }

    public void put(OurString key, Integer value) {
        trieRoot = put(trieRoot, key, value, 0);
    }

    private Node put(Node n, OurString key, Integer value, int d) {
        if (n == null) {
            n = new Node();
        }
        if (key.getValue().length() == d) {
            n.value = value;
            return n;
        }
        int index = key.key(d);
        n.links[index] = put(n.links[index], key, value, d + 1);
        return n;
    }

    public Integer get(OurString key) {
        Node node = get(trieRoot, key, 0);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    private Node get(Node n, OurString key, int d) {
        if (n == null) {
            return null;
        }
        if (key.getValue().length() == d) {
            return n;
        }
        int index = key.key(d);
        return get(n.links[index], key, d + 1);
    }

    public void delete(OurString key) {
        Node n = delete(trieRoot, key, 0);
        if (n != null) {
            n.value = null;
        }
    }

    private Node delete(Node n, OurString key, int d) {
        if (key.getValue().length() == d) {
            return null;
        } else {
            int index = key.key(d);
            if(n.links[index] != null) {
                n.links[index] = delete(n.links[index], key, d + 1);
            }
        }
        if (n.value != null){
            return null;
        }
        for(int i = 0; i < c; i++){
            if(n.links[i] != null){
                return n;
            }
        }
        return null;
    }
}