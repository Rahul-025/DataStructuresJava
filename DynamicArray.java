class MyArr {
    private int usedSize;
    private int maxSize;
    private int arr[];

    // Constructors
    MyArr() {
        this.maxSize = 10;
        this.usedSize = 0;
        arr = new int[maxSize];
    }

    MyArr(int size) {
        this.maxSize = size;
        this.usedSize = 0;
        arr = new int[maxSize];
    }

    // Insertion Operations
    public void push(int data) {
        if (usedSize == maxSize)
            extend();
        arr[usedSize++] = data;
    }

    public void insert(int index, int data) {
        if(index > usedSize)
            System.out.println("Cant insert at index " +index+ " index out of bounds.");  
        else if (index == usedSize)
            push(data);
        else {
            shift(index, "insert");
            arr[index] = data;
        }
    }

    // Extend array if full
    private void extend() {
        this.maxSize = (int)(this.maxSize * 1.5);
        int newArr[] = new int[maxSize];

        for (int i = 0; i < this.usedSize; i++) {
            newArr[i] = arr[i];
        }
        this.arr = newArr;
    }

    // Deletion Operations
    public int pop() {
        int val = arr[usedSize--];
        return val;
    }

    public void delete(int index) {
        if(index >= usedSize)
        System.out.println("Cant delete at index " +index+ " index out of bounds."); 
        else if(index == usedSize-1)
            pop();
        else {
            shift(index, "delete");
        }
    }

    // Shifting Operation
    private void shift(int index, String type) {
        if (type.equalsIgnoreCase("insert")) {
            for (int i = this.usedSize - 1; i >= index; i--) {
                this.arr[i + 1] = this.arr[i];
            }
            this.usedSize++;
        } 
        else {
            for (int i = index; i <= usedSize - 2; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.usedSize--;
        }
    }

    void show() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class DynamicArray {
    public static void main(String[] args) {
        MyArr array = new MyArr();
        array.push(10);
        array.push(15);
        array.push(20);
        array.push(25);
        array.pop();
        array.insert(3, 100);
        array.delete(3);
        array.show();

    }
}