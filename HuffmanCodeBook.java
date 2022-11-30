import java.util.Iterator;

public class HuffmanCodeBook implements Iterable<Character> {

    //class that stores char as key and binary code as value
    private char[] keys;
    private BinarySequence[] values;
    private int size;
    private int capacity;

    //initializes values
    public HuffmanCodeBook(){
        capacity = 2;
        keys = new char[capacity];
        values = new BinarySequence[capacity];
        size = 0;
    }
    
    //adds a key value pair to the code book
    public void addSequence(char key, BinarySequence value){
       //add the key value pair to the code book in sorted order
         if(size == capacity){
              resize();
         }
        int i = 0;
        while(i < size && key > keys[i]){
            i++;
        }
        for(int j = size; j > i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        size++;

    }
    private void resize()
    {
        capacity *= 2;
        char[] tempKeys = new char[capacity];
        BinarySequence[] tempValues = new BinarySequence[capacity];
        for(int i = 0; i < size; i++){
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        keys = tempKeys;
        values = tempValues;
    }

    //returns the binary code for a given key
    public BinarySequence getSequence(char key){
        for(int i = 0; i < size; i++){
            if(keys[i] == key){
                return values[i];
            }
        }
        return null;
    }
    //check if the code book contains a given key
    public boolean contains(char key){
        for(int i = 0; i < size; i++){
            if(keys[i] == key){
                return true;
            }
        }
        return false;
    }
    //check if every char in string is in the code book
    public boolean containsAll(String s){
        for(int i = 0; i < s.length(); i++){
            if(!contains(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    //returns the size of the code book
    public int size(){
        return size;
    }
    //encode a string using the code book
    public BinarySequence encode(String s){
        BinarySequence result = new BinarySequence();
        for(int i = 0; i < s.length(); i++){
            BinarySequence bs = getSequence(s.charAt(i));
            if(bs!=null){

                result.append(bs);
            }
        }
        return result;
    }

    //an iterator for the codebook 
    public Iterator<Character> iterator(){
        return new HuffmanCodeBookIterator();
    }
    private class HuffmanCodeBookIterator implements Iterator<Character>{
        private int i = 0;
        public boolean hasNext(){
            return i < size;
        }
        public Character next(){
            return keys[i++];
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

}
