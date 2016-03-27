/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author Alexey
 * Represents array of unique Integers.
 */
public class UniqueArray {
    /**
     * Array of unique Integers.
     */
    private final ArrayList<Integer> array;
    
    /**
     * Stores entries of elements to avoid duplicates.
     */
    private final TreeSet<Integer> entries;
    
    public UniqueArray(){
        array = new ArrayList<>(5);
        
        entries = new TreeSet<>();
    }
    
    /**
     * Adds new value to array.
     * If array already contains such value does nothing.
     * @param value Value to add to array.
     */
    public void add(final Integer value){
        if(!entries.contains(value)){
            array.add(value);
            
            entries.add(value);
        }
    }
    
    /**
     * Removes value from array.
     * If array does not contain such value does nothing.
     * @param value Value to remove from array.
     */
    public void remove(final Integer value){
        if(entries.contains(value)){
            entries.remove(value);
        }
    }
    
    /**
     * Sorts array by descending.
     */
    public void sortDesc(){
        Collections.sort(array, Collections.reverseOrder());
    }
    
    /**
     * Returns count of elements in array.
     * @return Count of elements in array.
     */
    public int getCountOfElements(){
        return array.size();
    }
    
    /**
     * Returns element by its index.
     * @param index Index of element to return.
     * @return Element with specified index.
     * @throws IndexOutOfBoundsException If index is incorrect.
     */
    public int getAt(final int index) throws IndexOutOfBoundsException{
        return array.get(index);
    }
    
    /**
     * Returns True if array is not empty.
     * Returns False otherwise.
     * @return True if array is not empty. False otherwise.
     */
    public boolean hasElements(){
        return array.size() > 0;
    }
}
