import Singleton.LazyInitialization.LibraryCatalog;

public class Main {
    public static void main(String[] args) {

        //Lazy Initialization
        var LazySingleton1 = LibraryCatalog.getInstance();
        var LazySingleton2 = LibraryCatalog.getInstance();
        System.out.println(LazySingleton1 == LazySingleton2);

        //Thread-Safe Singleton
        var hreadSafe1 = Singleton.ThreadSafe.LibraryCatalog.getInstance();
        var hreadSafe2 = Singleton.ThreadSafe.LibraryCatalog.getInstance();
        System.out.println(hreadSafe1 == hreadSafe2);

        //Double-Checked Locking
        var DoubleCheckedLocking1 = Singleton.DoubleCheckedLocking.LibraryCatalog.getInstance();
        var DoubleCheckedLocking2 = Singleton.DoubleCheckedLocking.LibraryCatalog.getInstance();
        System.out.println(DoubleCheckedLocking1 == DoubleCheckedLocking2);

        //Bill Pugh Singleton
        var BillPugh1 = Singleton.BillPugh.LibraryCatalog.getInstance();
        var BillPugh2 = Singleton.BillPugh.LibraryCatalog.getInstance();
        System.out.println(BillPugh1 == BillPugh2);

        //Enum Singleton
        var Enum1 = Singleton.Enum.LibraryCatalog.INSTANCE;
        var Enum2 = Singleton.Enum.LibraryCatalog.INSTANCE;
        System.out.println(Enum1 == Enum2);
    }
}