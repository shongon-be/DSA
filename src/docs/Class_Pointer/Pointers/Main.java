package docs.Class_Pointer.Pointers;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
    // Not using pointers
        int a = 16;
        int b = a;  // assigned b equals to value of 'a'

        /* Explain the statement "int b = a "
            Có thể diễn giải như sau:
            - khởi tạo biến a = 16
            - gán cho biến b bằng biến a
                int b = a;
             -> int b = 16; (Do giá trị của biến a là 16)
        */
        System.out.println("Value before updated 'a': " + a);
        System.out.println("Value before updated 'a': " + b);

        a = 32; // updated value of 'a'
        /*
            a = 32;
            b = 16; (Do trước đó giá trị của a là 16)
        */ System.out.println();

        System.out.println("Value after updated 'a': " + a);
        System.out.println("Value after updated 'a': " + b);
        // => Sau khi update giá trị của biến 'a' thì giá trị của a & b khác nhau

        System.out.println("===========================================");

    // Using pointers

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.put("value", 100);
        map2 = map1;

        System.out.println("Before: " + map1);
        System.out.println("Before: " + map2);

        map1.put("value", 200);
        System.out.println();

        System.out.println("After: " + map1);
        System.out.println("After: " + map2);

        /*
            Lý do vì sao 'map1' và 'map2' đều thay đổi giá trị khi chỉ thay đổi giá trị của
            'map1'
                 {value=100} được coi là 1 object (*)
                    lưu ở heap memory.

            khi khởi tạo 'map1' giá trị của 'map1' sẽ trỏ tới (*)
            sau đó gán giá trị của 'map2' = 'map1', map2 cũng sẽ trỏ tới (*)

            nếu thay đổi (*) thì cả 'map1' & 'map2' cũng sẽ ảnh hưởng.
        */
    }
}
