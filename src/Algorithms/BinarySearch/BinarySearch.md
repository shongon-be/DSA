# 🧠 Binary Search - Java Notes

## 1. Định nghĩa
- Binary Search là cách nhanh nhất để tìm 1 phần tử bên trong một **mảng đã được sắp xếp** (`sorted array`).
- Thay vì kiểm tra từng phần tử (giống như `linear search`), nó sẽ **chia đôi mảng** sau mỗi bước.

---

## 2. Điều kiện áp dụng
- Mảng **phải được sắp xếp sẵn** (tăng dần hoặc giảm dần).
- Bài toán cần tìm một **giá trị cụ thể** (target).
- Không áp dụng được với:
    - Mảng chưa sắp xếp.
    - Cấu trúc dữ liệu không hỗ trợ truy cập chỉ số trực tiếp (như `Linked List`).

---

## 3. Workflow (Quy trình)
```java
int left = 0;
int right = arr.length - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (arr[mid] == target) return mid;
    if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}

return -1; // Không tìm thấy
```

---

## 4. Cách hoạt động
- Bắt đầu với 2 con trỏ:
    -left = 0 (chỉ số đầu).
    -right = arr.length - 1 (chỉ số cuối).
- Tìm phần tử ở giữa:
  - `mid = (left + right) / 2` (trường hợp học tập).
  - Thực tế nên dùng: `mid = left + (right - left) / 2` để tránh bị tràn số (overflow).
- So sánh giá trị tại `mid` với `target`:
  - Nếu bằng → ✅ Trả về mid
  - Nếu nhỏ hơn → 🔍 Tìm bên phải → `left = mid + 1`
  - Nếu lớn hơn → 🔍 Tìm bên trái → `right = mid - 1`
- Lặp lại cho đến khi: `left > right`
- Nếu không tìm thấy → ❌ Trả về `-1`

---

## 5. Ví dụ minh họa
Input:
```java
int[] arr = {2, 4, 7, 10, 13, 18, 21};
int target = 13;
```
Flow:
- Step 1:
    - `left = 0`, `right = 6`
    - `mid = (0+6)/2 = 3 → arr[3] = 10`
    - 10 < 13 → Tìm từ phần bên phải

- Step 2:
  - `left = 4`, `right = 6`
  - `mid = 5 → arr[5] = 18`
  - 18 > 13 → Tìm từ phần bên trái

- Step 3:
  - `left = 4`, `right = 4`
  - `mid = 4 → arr[4] = 13` ✅ Tìm thấy target!

---

## 6. Giải thích cách tính `mid` an toàn
Thay vì: 
```java
mid = (left + right) / 2; // Có thể gây overflow
```
Sử dụng:
```java
mid = left + (right - left) / 2;
```
-> Bắt đầu từ `left`, rồi đi thêm một nửa quãng đường đến `right`.

Ví dụ:
```text
left = 20, right = 30
→ right - left = 10
→ 10 / 2 = 5
→ mid = left + 5 = 25
```

---

## 7. Time Complexity
- Best / Worst case: `O(log n)`
  - Vì mỗi lần loại bỏ 1 nửa mảng.
- Tốt hơn nhiều so với `linear search: O(n)`