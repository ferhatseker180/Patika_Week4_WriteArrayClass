public class MyList<T> {

    private int capacity = 10;
    private int count;
    T[] arr;

    // Constructor değer almazsa default atanacak dizi boyutu...
    public MyList() {
        arr = (T[]) new Object[10];
    }

    // Constructora capacity değeri girilirse oluşturulacak array...
    public MyList(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    // Dizideki eleman sayısını verir...
    public int size() {
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }

    // Dizinin kapasitesini verir
    public int getCapacity() {
        return this.capacity;
    }

    // Diziye eleman ekler eğer kapasite yetersiz ise kapasiteyi 2 katına çıkarır.
    public void add(T data) {
        if (this.size() == this.getCapacity()) {
            this.capacity *= 2;
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            newArr[(arr.length)] = data;
            arr = newArr;
        } else {
            arr[this.size()] = data;
        }
    }

    // İndex'deki elemanın değerini döndürür
    public T get(int index) {
        return arr[index];
    }

    // Belirtilen indexteki elemanı siler
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            return;
        }
        for (int i = index; i < size() - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size() - 1] = null;
    }

    // Girilen index'deki değeri data ile değiştirir eğer index değeri hatalıysa null değer hatası verir.
    public void set(int index, T data) {
        for (int i = 0; i < arr.length; i++) {
            if (index > arr.length) {
                System.out.println("Null Değer");
                break;
            }
            if (i == index) {
                arr[i] = data;
            }
        }
    }

    // Dizideki tüm elemanları yazdırır ve listeler.
    public void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Girilen datanın index değerini döndürür eğer data yoksa -1 döndürür.
    public int indexOf(T data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }


    // Girilen datanın bulunduğu son konumun indexini döndürür.
    public int lastIndexOf(T data) {
        for (int i = this.arr.length - 1; i >= 0; i--) {
            if (arr[i] == (data)) {
                return i;
            }
        }
        return -1;
    }

    // Listenin ilk indexini kontrol ederek boş olup olmadığını anlayabiliriz, diğerlerine bakmaya gerek yok çünkü liste 0.index'den başlamalıdır.
    public boolean isEmpty() {
        if (arr[0] == null) {
            return true;
        }
        return false;
    }

    // Bir arrayi diğerine kopyalama işlemini gerçekleştirir.
    public T[] toArray() {
        T[] copyArr = (T[]) new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = this.arr[i];
        }
        return copyArr;
    }

    // Dizideki tüm elemanları siler.
    public void clear() {
        for (int i = arr.length + 1; i >= 0; i--) {
            remove(i);
            //  this.arr[i] = null;
        }
    }

    // Başlangıç ve bitiş indexleri verilmiş arrayin listelenmesi sağlanmıştır.
    public void subList(int start, int finish) {
        if ((start < 0) || (start > arr.length) || (finish <= 0) || (finish > arr.length)) {
            System.out.println("Geçersiz Değer Girildi!!");
        }
        for (int i = start; i <= finish; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Dizinin girilen parametreyi içerip içermediğini kontrol eder.
    public boolean contains(T data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return count;
    }


}
