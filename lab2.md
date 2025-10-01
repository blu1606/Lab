# Lab 2 1NF -> 3NF
---

## 1NF (Dạng Chuẩn Thứ Nhất)

**1. Giải thích 1NF:**

- Single Value (không có multivalued attributes).
- Có primary Key.

### Bước 1: Áp dụng 1NF (Loại bỏ Nhóm Lặp Lại)

Dữ liệu ban đầu vi phạm 1NF vì:
1.  **Lịch sử Sức khỏe** có nhiều `VISIT DATE`/`PROCEDURE` cho một `PET ID`.
2.  **Hóa đơn** có nhiều dòng mục (PET/PROCEDURE/AMOUNT) cho một `INVOICE #`.

#### 1. HEALTHY\_HISTORY\_1NF
Chúng ta lặp lại thông tin thú cưng và tách từng `procedure` thành một dòng riêng biệt. Đồng thời, tách trường `PROCEDURE` thành **ID** và **DESCRIPTION** để đảm bảo tính Atomic Value.

| PET ID | PET NAME | PET TYPE | PET AGE | OWNER | VISIT DATE | PROCEDURE ID | PROCEDURE DESCRIPTION |
| :----: | :------: | :------: | :-----: | :-------: | :----------: | :----------: | :--------------------: |
| 246 | ROVER | DOG | 12 | SAM COOK | JAN 13/2002 | 01 | RABIES VACCINATION |
| 246 | ROVER | DOG | 12 | SAM COOK | MAR 27/2002 | 10 | EXAMINE and TREAT WOUND |
| 246 | ROVER | DOG | 12 | SAM COOK | APR 02/2002 | 05 | HEART WORM TEST |
| 298 | SPOT | DOG | 2 | TERRY KIM | JAN 21/2002 | 08 | TETANUS VACCINATION |
| 298 | SPOT | DOG | 2 | TERRY KIM | MAR 10/2002 | 05 | HEART WORM TEST |
| 341 | MORRIS | CAT | 4 | SAM COOK | JAN 23/2001 | 01 | RABIES VACCINATION |
| 341 | MORRIS | CAT | 4 | SAM COOK | JAN 13/2002 | 01 | RABIES VACCINATION |
| 519 | TWEEDY | BIRD | 2 | TERRY KIM | APR 30/2002 | 20 | ANNUAL CHECK UP |
| 519 | TWEEDY | BIRD | 2 | TERRY KIM | APR 30/2002 | 12 | EYE WASH |


**Khóa Chính (Candidate Key):** {**PET ID**, **VISIT DATE**, **PROCEDURE ID**}

#### 2. INVOICE\_1NF
Chúng ta lặp lại thông tin tiêu đề hóa đơn cho mỗi dòng mục chi phí.

| INVOICE \# | DATE | OWNER DETAILS | PET NAME | PROCEDURE DESCRIPTION | AMOUNT | TOTAL | TAX | AMOUNT OWING |
| :---------: | :---------: | :---------------------------------------------------------------------------------------------------------------------: | :--------: | :--------------------: | :------: | :-----: | :---: | :------------: |
| 987 | JAN 13/2002 | MR. RICHARD COOK - 123 THIS STREET - MY CITY, ONTARIO Z5Z 6G6 | ROVER | RABIES VACCINATION | 30.00 | 54.00 | 4.32 | 58.32 |
| 987 | JAN 13/2002 | MR. RICHARD COOK - 123 THIS STREET - MY CITY, ONTARIO Z5Z 6G6 | MORRIS | RABIES VACCINATION | 24.00 | 54.00 | 4.32 | 58.32 |

**Khóa Chính (Ứng cử viên):** {**INVOICE \#**, **PET NAME**, **PROCEDURE DESCRIPTION**}

---

## 2NF 

**Giải thích 2NF:** Một quan hệ ở **2NF** nếu nó ở 1NF và tất cả các thuộc tính không phải là khóa đều **phụ thuộc hoàn toàn** (fully functionally dependent) vào **toàn bộ Khóa Chính**. Nếu có **Phụ thuộc một phần** (Partial Dependency), ta phải tách bảng.

### Bước 2: Áp dụng 2NF (Loại bỏ Phụ thuộc một phần)

#### 1. Phân tách HEALTHY\_HISTORY\_1NF

* **PET ID**  -> {PET NAME, PET TYPE, PET AGE, OWNER}
* **PROCEDURE ID** -> {PROCEDURE DESCRIPTION}

| Tên Bảng | Khóa Chính (PK) | Lý do |
| :---: | :---: | :---: |
| **PET** | **PET ID** | Tách thông tin thú cưng |
| **PROCEDURE\_MASTER** | **PROCEDURE ID** | Tách thông tin thủ tục |
| **VISIT** | {**PET ID**, **VISIT DATE**, **PROCEDURE ID**} | Ghi lại sự kiện thăm khám |

#### 2. Phân tách INVOICE\_1NF

* **INVOICE \#** -> {DATE, OWNER DETAILS, TOTAL, TAX, AMOUNT OWING}

| Tên Bảng | Khóa Chính (PK) | Lý do |
| :---: | :---: | :---: |
| **INVOICE\_HEADER** | **INVOICE \#** | Tách thông tin tiêu đề hóa đơn |
| **INVOICE\_LINE (2NF)** | {**INVOICE \#**, **PET NAME**, **PROCEDURE DESCRIPTION**} | Giữ lại dòng mục chi phí |

---

## 3NF (Dạng Chuẩn Thứ Ba)

**Giải thích 3NF:** Một quan hệ ở **3NF** nếu nó ở 2NF và không có **Phụ thuộc Bắc cầu** (Transitive Dependency). Tức là, một thuộc tính không phải là khóa không được phụ thuộc vào một thuộc tính không phải là khóa khác.

### Bước 3: Áp dụng 3NF (Loại bỏ Phụ thuộc Bắc cầu)

Các bảng `PET` và `INVOICE_HEADER` vẫn còn vấn đề về dữ liệu trùng lặp và Phụ thuộc Bắc cầu.

#### 1. Tách Bảng OWNER (Loại bỏ Phụ thuộc Bắc cầu)

Tách thông tin chi tiết về chủ sở hữu (`OWNER DETAILS`) khỏi `INVOICE_HEADER` và `OWNER` khỏi `PET`.

| Tên Bảng | Khóa Chính (PK) | Thuộc tính Khác |
| :---: | :---: | :---: |
| **OWNER** | **OWNER ID** | NAME, ADDRESS, POSTAL CODE |

#### 2. Chuẩn hóa các Bảng còn lại

* **PET (3NF):** Thay **OWNER** bằng **OWNER ID (FK)**.
* **INVOICE (3NF):** Thay **OWNER DETAILS** bằng **OWNER ID (FK)** và giữ các trường về tổng tiền.
* **INVOICE\_LINE (3NF):** Thay các trường tên/mô tả bằng **PET ID (FK)** và **PROCEDURE ID (FK)** để đảm bảo tính toàn vẹn tham chiếu.

### Mô Hình Quan Hệ Cuối Cùng ở 3NF

| Tên Bảng | Khóa Chính (PK) | Khóa Ngoại (FK) |
| :---: | :---: | :---: |
| **OWNER** | **OWNER ID** | - |
| **PET** | **PET ID** | OWNER ID |
| **PROCEDURE\_MASTER** | **PROCEDURE ID** | - |
| **VISIT** | {**PET ID**, **VISIT DATE**, **PROCEDURE ID**} | PET ID, PROCEDURE ID |
| **INVOICE** | **INVOICE \#** | OWNER ID |
| **INVOICE\_LINE** | {**INVOICE \#**, **PET ID**, **PROCEDURE ID**} | INVOICE \#, PET ID, PROCEDURE ID |

#### 1. Bảng OWNER (Chủ Sở Hữu)

| OWNER ID (PK) | NAME | ADDRESS | POSTAL CODE |
| :-----------: | :-------: | :-------------------------------------------: | :-----------: |
| OC01 | SAM COOK / MR. RICHARD COOK | 123 THIS STREET - MY CITY, ONTARIO | Z5Z 6G6 |
| OC02 | TERRY KIM | (Unknown) | (Unknown) |

#### 2. Bảng PET (Thú Cưng)

| PET ID (PK) | PET NAME | PET TYPE | PET AGE | OWNER ID (FK) |
| :---------: | :------: | :------: | :-----: | :-----------: |
| 246 | ROVER | DOG | 12 | OC01 |
| 298 | SPOT | DOG | 2 | OC02 |
| 341 | MORRIS | CAT | 4 | OC01 |
| 519 | TWEEDY | BIRD | 2 | OC02 |

#### 3. Bảng PROCEDURE\_MASTER (Danh Mục Thủ Tục)

| PROCEDURE ID (PK) | PROCEDURE DESCRIPTION |
| :---------------: | :--------------------: |
| 01 | RABIES VACCINATION |
| 10 | EXAMINE and TREAT WOUND |
| 05 | HEART WORM TEST |
| 08 | TETANUS VACCINATION |
| 20 | ANNUAL CHECK UP |
| 12 | EYE WASH |

#### 4. Bảng VISIT (Lần Ghé Thăm/Điều Trị)

| PET ID (FK) | VISIT DATE | PROCEDURE ID (FK) |
| :---------: | :----------: | :---------------: |
| 246 | JAN 13/2002 | 01 |
| 246 | MAR 27/2002 | 10 |
| 246 | APR 02/2002 | 05 |
| 298 | JAN 21/2002 | 08 |
| 298 | MAR 10/2002 | 05 |
| 341 | JAN 23/2001 | 01 |
| 341 | JAN 13/2002 | 01 |
| 519 | APR 30/2002 | 20 |
| 519 | APR 30/2002 | 12 |

#### 5. Bảng INVOICE (Hóa Đơn)

| INVOICE \# (PK) | DATE | OWNER ID (FK) | TOTAL\_AMOUNT | TAX\_AMOUNT | AMOUNT\_OWING |
| :-------------: | :---------: | :-----------: | :-----------: | :-----------: | :------------: |
| 987 | JAN 13/2002 | OC01 | 54.00 | 4.32 | 58.32 |

#### 6. Bảng INVOICE\_LINE (Chi Tiết Hóa Đơn)

| INVOICE \# (FK) | PET ID (FK) | PROCEDURE ID (FK) | AMOUNT |
| :-------------: | :----------: | :---------------: | :------: |
| 987 | 246 | 01 | 30.00 |
| 987 | 341 | 01 | 24.00 |