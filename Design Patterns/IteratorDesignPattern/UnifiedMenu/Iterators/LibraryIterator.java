package IteratorDesignPattern.UnifiedMenu.Iterators;

public class LibraryIterator implements Iterator {

    private String[] libraryItems;
    int index = 0;

    public LibraryIterator(String [] libraryItems) {
        this.libraryItems = libraryItems;
    }

    @Override
    public boolean hasNext() {
        if(index >= libraryItems.length) {
            return false;
        }
        return true;
    }

    @Override
    public String next() {
        return libraryItems[index++];
    }
    
}
