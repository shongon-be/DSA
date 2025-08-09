## 1. Big O

| Thao tác                           | Độ phức tạp | Giải thích                        |
|------------------------------------|-------------|-----------------------------------|
| Access (truy cập node tại `pos`)   | O(n)        | Phải duyệt từ đầu đến node đó     | 
| Search (bằng `value`)              | O(n)        | Không có chỉ số index trực tiếp   |
| Insert đầu danh sách               | O(1)        | Thêm node mới, trỏ nó đến head cũ | 
| Insert giữa (có `pos`)             | O(n)        | Phải duyệt đến đúng chỗ để chèn   |
| Insert cuối (không có node `tail`) | O(n)        | Phải duyệt đến node cuối cùng     |
| Insert cuối (có node `tail`)       | O(1)        | Thêm node mới, trỏ tail cũ đến nó |
| Delete đầu danh sách               | O(1)        | Trỏ head sang node tiếp theo      |
| Delete giữa (có `pos`)             | O(n)        | Phải duyệt tới node trước nó      |
| Delete cuối                        | O(n)        | Phải duyệt đến node kế cuối       |

---

## 2. Linked List là gì?

- **Linked List** là một cấu trúc dữ liệu tuyến tính gồm nhiều phần tử, gọi là các `node`, được liên kết với nhau bằng con trỏ (`pointer` hoặc `reference`).

### a. Cấu trúc node:
- Với **Singly Linked List** (Danh sách liên kết đơn):
    - `value`: **giá trị** node lưu trữ.
    - `next`: tham chiếu đến `node tiếp theo`.
- Minh họa **singly linked list** : `Singly: [value | next] → [value | next] → null`

- Với **Doubly Linked List** (Danh sách liên kết đôi):
    - `value`: **giá trị** node lưu trữ.
    - `next`: tham chiếu đến `node kế tiếp`.
    - `prev`: tham chiếu đến `node phía trước`.
- Minh họa **doubly linked list** : `Doubly: null ← [prev | value | next] ↔ [prev | value | next] → null`

### b. Cách hoạt động:
- Các node **không nằm liền kề nhau** trong bộ nhớ như mảng (`array`), mà được cấp phát ngẫu nhiên ở các vị trí khác nhau.
- Mỗi node giữ địa chỉ của node tiếp theo để tạo thành chuỗi liên kết thông qua con trỏ.


#### Ví dụ minh họa liên kết giữa các node:
    node:      [20]      [9]
    address:    121      372
    
    Node [20] có next = 372 → trỏ đến node [9]
    
    Kết quả:   [20] → [9]

### c. Các khái niệm quan trọng:
- `head`: node đầu tiên trong danh sách.
- `tail`: node cuối cùng, có `next = null`.
- Danh sách rỗng: khi `head = null`.

---

**Note:**

1. Thêm vào giữa danh sách - insertAt(2, 6):

```text
Pos:    0   →   1   →   2   →   3
List:   1   →   3   →   5   →   7   → null
```

- Node `6` sẽ được chèn vào vị trí thứ 2, tức là: trước node `5`, sau node `3`.
- Flow:
    ```text
     List:   1   →   3   →   5   →   7   → null
                             ↑
                             6
    
     List:   1   →   3      5   →   7   → null
                        ↘   ↑
                            6
  
     List:   1   →   3   →   6   →   5   →   7   → null (Updated list)
     ```
- Giải thích:
    - Step 1:
        - Ghi nhận node tại pos(1) là node `3`.
        - Ghi nhận node tại pos(2) là node `5`.
    - Step 2: `newNode(6).next = node5`. (tức là trỏ node `6` tới node `5`)
    - Step 3: `node3.next = newNode(6)`. (tức là node `3` không còn trỏ tới node `5`, mà trỏ tới node `6`)
    - Final result: `1 → 3 → 6 → 5 → 7 → null`

2. Xóa giữa danh sách - deleteAt(2):
```text
Pos:    0   →   1   →   2   →   3
List:   1   →   3   →   5   →   7   → null
```
- Node ở vị trí thứ 2 - `pos(2)` sẽ bị xóa đi.
  - Node ở v trí 1 sẽ nối đến node ở vị trí 3.

  - Flow: 
    ```text
                  pos(1)         pos(2)           
                    ↓         ↙
    List:   1   →   3   →   5  
                            ↓
                            7   → null
                          ↗
                       pos(3)
    
    List:   1   →   3       5  
                       ↘    ↓
                            7   → null
    
    
    List: 1  →  3  →  7  →  null (updated list)
    ```
  - Giải thích:
    - Step 1: 
      - Xác định node ở pos(1) = node '3'.
      - Xác định node ở pos(2) = node '5'.
      - Xác định node ở pos(3) = node '7'.
    - Step 2: `node3.next = node5.next`. Cho node `3` nối đến node `7`.
    - Step 3: node `5` bị **"bỏ rơi"** khỏi danh sách. (không còn được `node` khác tham chiếu tới).
      - bị JVM sẽ dọn dẹp node `5` trong GC (garbage collection).
    - Final result: `1 → 3 → 7 → null`.