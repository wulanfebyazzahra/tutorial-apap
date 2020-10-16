# Tutorial APAP
## Authors
* **Wulan Febyazzahra Putri** - *1806147205* - *APAP A*

---
## Tutorial 1
### What I have learned today

### Github

1. **Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
Issue tracker adalah sebuah sistem yang dapat melakukan *tracking issues* secara terintegrasi. Sistem atau fitur ini nanti bisa digunakan oleh tim developer untuk memantau masalah yang ada. Masalah yang bisa diselesaikan dengan Issue Tracker adalah seperti saat ingin membuat fitur baru atau ingin menyelesaikan suatu *error* atau *bugs* pada kodingan.

2. **Apa perbedaan dari git merge dan git merge --squash?**
*Git merge* adalah suatu *command* dalam git untuk membuat branch yang bercabang menjadi satu kembali atau dengan kata lain mengintegrasikan kembali branch tersebut menjadi satu. Sedangkan git merge --squash adalah penggabungan cabang-cabang seperti pada merge biasa namun tidak akan menghasilkan merge record atau commit record, sehingga pull-request yang kita buat tidak akan berubah.

3. **Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**
Dengan menggunakan Version Control System kita bisa dengan mudah membandingkan files, mengidentifikasi perbedaan, melakukan merge jika ada perubahan. Version control system juga berfungsi agar kita bisa *keep track* versi aplikasi mana yang sedang dalam proses pengembangan, QA, atau produksi. Selain itu selama pengembangan kita juga bisa memiliki versi kode yang independen, dan saat pada saat tahap terakhir kita bisa dengan mudah menggabungkan versi-versi yang diinginkan. 


### Spring

4. **Apa itu library & dependency?**
**Library** adalah kumpulan package atau koleksi kelas yang telah disediakan oleh Spring. Kita dapat menggunakan library ini kita harus memanggilnya dengan syntax **import**, dengan adanya library ini kita tidak perlu membuat suatu kode dari 0. Sedangkan, **dependency** bisa dikatakan suatu ketergantungan. Dapat diartikan bahwa dependency adalah library yang dibutuhkan oleh suatu aplikasi.  

5. **Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**
Kita harus menggunakan Maven sebagai tools untuk mendapatkan dan menangani dependencies yang ada. Alternatif dari Maven bisa menggunakan Gradle, Scons, CMake, dll.

6. **Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?**
Karena spring framework tergolong *light* maka framework ini sangat terkenal bukan hanya untuk pengembangan web, tapi bisa juga untuk:
 - Pengembangan suatu aplikasi 
 - Pengembangan suatu softwate
 - Melakukan komunikasi dengan suatu basis data
 - Melakukan proteksi terhadap aplikasi web
 - Melakukan beberapa pengujian
 - Bisa dikembangkan untuk membuat web dengan Spring MVC dan RESTful service.

7. **Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?**
Pada dasarnya keduanya memiliki tujuan untuk mengekstrak values dari HTTP request. Perbedaannya adalah:

**@RequestParam:**
 - Memperoleh request parameters dari URL atau biasa disebut query paremeters
 - Lebih cocok digunakan pada aplikasi web aplikasi tradisional

**@PathVariable:**
 - Mengekstrak value dari URI
 - Lebih cocok digunakan pada web berbasis RESTful service


### What I did not understand
- [ ] Bagaimana cara mengimplementasikan RESTful API?

 
### Sources:
 - Slide pembelajaran APAP
 - https://github.blog/2009-04-15-github-issue-tracker/
 - https://www.seguetech.com/a-review-of-software-version-control-systems-benefits-and-why-it-matters/#:~:text=Version%20Control%20Benefits,development%2C%20QA%2C%20and%20production
 - https://www.vogella.com/tutorials/DependencyInjection/article.html
 - https://www.quora.com/What-is-Spring-Framework-used-for#:~:text=Millions%20of%20developers%20around%20the,and%20speed%20up%20development%20time.
 - https://www.javacodegeeks.com/2017/10/differences-requestparam-pathvariable-annotations-spring-mvc.html
 - https://en.wikipedia.org/wiki/Uniform_Resource_Identifier



---
## Tutorial 2

1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?

**Jawab**:
Jika dijalankan akan terjadi Whitelabel Error Page Service Error 500, karena pada controller sudah ada perintah return "add-hotel". Controller fungsinya adalah melakukan mapping dari sebuah *request* yang dinput, lalu disini sudah diminta untuk memanggil *template* html add-hotel yang sebenarnya belum dibuat, tentu ini akan menyebabkan *error*.


2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat!

**Jawab**:
Anotasi @Autowired pada controller merupakan implementasi dari konsep dependancy injection. Autowired ini memungkinkan kita untuk memasukan dependensi objek secara implisit. Jadi peletakan autowired pada HotelControlller itu agar kita tidak perlu membuat setter, getter, atau constructor, karena autowired sudah otomatis akan mencari service yang mengimplementasikan interface HotelService.


3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?

**Jawab**:
Jika dijalankan akan terjadi Bad Request 400, ini dikarenakan parameter nomor telepon tidak dicantumkan dimana atribut nomor telepon seharusnya *required* dan tidak boleh null.

4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?

**Jawab**:
http://localhost:8080/hotel/view?idHotel=1&namaHotel=Papa%20APAP
atau
http://localhost:8080/hotel/view?idHotel=1

5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

**Jawab**:
Jika saya klik tombol kembali atau pergi ke http://localhost:8080/hotel/viewall maka yang terjadi adalah saya bisa melihat seluruh hotel beserta informasi hotel yang sudah terdaftarkan. 

Hasil Screenshot:
https://ibb.co/Jvw1RCS

### Sources:
 - https://www.javatpoint.com/autowiring-in-spring


---
## Tutorial 3
1. Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?

**Jawab**:
Kegunaan dari method findAllByHotelId di KamarDb adalah untuk mencari semua kamar yang tersedia pada suatu hotel berdasarkan Id hotel tersebut, nantinya seluruh kamar ini akan dimasukkan kedalam list.

2. Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?

**Jawab**:
Method addHotelFormPage memiliki fungsi yaitu untuk menerima request dari HTTP. Nantinya method ini akan menggunakan GetMapping untuk menangani method GET dari HTTP dan mengambil data dari request tersebut.

Method addHotelSubmit memiliki fungsi yaitu menangani method POST seperti *add* atau *update* dengan menggunakan PostMapping. 

3. Jelaskan kegunaan dari JPA Repository!

**Jawab**:
JPA Repository merupakan sebuah modul dari JPA yang berisi *namespace custom*, modul ini memungkinkan penentuan *repository beans*. Modul ini juga berisi fitur dan atribut elemen tertentu yang dikhususkan untuk JPA. Jadi dengan menggunakan JPA Repository ini kita bisa membuat *repository custom* sendiri di lokal, selain itu kita juga bisa menghubungkan relational database lokal kita dengan Java.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?

**Jawab**:
- Pada HotelModel, hubungan relasinya dengan KamarModel adalah @OneToMany. Ini dikarenakan hotel dapat memiliki banyak kamar. 

- Pada KamarModel, hubungan relasinya dengan HotelModel adalah @ManytoOne, karena banyak kamar dapat dimiliki oleh satu hotel. 

- Pada KamarModel terdapat hubungan @JoinColumn dimana fungsinya adalah untuk menggabungkan dua kolum idHotel dengan Id.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!

**Jawab**:

**FetchType.LAZY** memiliki kegunaan yaitu untuk memuat beberapa collecton object (child) yang dibutuhkan saja saat object parent di fetch. Collection object (child) hanya dimuat jika secara eksplisit dibutuhkan via getter method. Dalam kata lain inisialisasi ini hanya melakukan fetch hanya ketika suatu data dibutuhkan. Tujuan inisialisasi ini adalah untuk meningkatkan *performance*, dimana dengan inisialiasi ini komputasi yang tidak terlalu dibutuhkan akan dihindari. Selain itu inisialisasi ini akan mengurangi *memory requirements*. Contoh kasusnya dalam implementasi tutorial ini adalah kita akan menggunakan FetchType.Lazy saat mau mengakses listkamar pada hotel, jadi kita hanya mengakses data yang dibutuhkan saja.

**FetchType.EAGER** memiliki kegunaan yaitu untuk memuat semua collection object (child) sesaat setelah object parent di fetch. Dalam kata lain inisialisasi ini akan melakukan fetch secara bersamaan. Contoh implementasinya pada tutorial 3 ini adalah saat kita ingin melihat keseluruhan hotel, dimana pastinya akan secara bersamaan datanya semuanya diakses.

**CascadeType.ALL** memiliki kegunaan yaitu untuk memuat semua *actions* secara keseluruhan. Contohnya adalah ketika kita menghilangkan sebuah *parent*, maka tentu *child*-nya akan hilang juga.

### Sources:
 - https://www.java2novice.com/hibernate/eager-vs-lazy-fetch-type/#:~:text=FetchType.,is%20actually%20fetched%20by%20hibernate.
 - https://docs.spring.io/spring-data/jpa/docs/1.3.4.RELEASE/reference/html/jpa.repositories.html
 - https://www.baeldung.com/jpa-join-column


---
## Tutorial 4

1. Jelaskan perbedaan th:include dan th:replace!

**Jawab**:
Pada dasarnya th:include dan th:replace merupakan suatu bentuk dari host tag. Tujuannya adalah untuk mengimplementasi fragment Thymeleaf. Fragment pada Thymeleaf merupakan suatu potongan kode yang dapat diimplementasikan ke beberapa template.

th:include akan memasukkan konten fragment ke host tag, namun yang dimasukkan hanya konten yang dispesifikasikan saja. th:replace tidak akan memasukkan konten fragment yang atributnya th:fragment.

th:replace akan menggantikan host tag dengan konten fragment yang spesifik. th:replace akan memasukkan konten fragment yang atributnya th:fragment.

2. Jelaskan apa fungsi dari th:object!

**Jawab**:
Fungsi dari th:object adalah untuk menspesifikasi objek yang terikat dengan data pada suatu form.


3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?

**Jawab**:
Pada dasarnya penggunaan * dan $ keduaya sama-sama digunakan untuk melakukan *variable expression*. Perbedaannya adalah $ digunakan ketika akan melakukan *expression* pada keseluruhan atribut dari th:object. Sedangkan * akan digunakan untuk melakukan *expression* pada suatu atribut spesifik dari th:object.

4. Bagaimana kamu menyelesaikan latihan nomor 3?

**Jawab**:
Untuk menyelesaikan latihan nomor 3, yang saya lakukan adalah menambahkan bagian fragment.html, disana saya menambahkan atribut th:text = "${pagename}" pada elemen dari HTML-nya. Lalu nanti pada setiap templates di navbarnya saya akan mengimplementasikan fragment dengan memasukan nama pagename sesuai dengan halamannya.

### Sources:
 - https://attacomsian.com/blog/thymeleaf-fragments#:~:text=A%20fragment%20in%20Thymeleaf%20is,repeated%20used%20on%20multiple%20pages.
 - https://www.baeldung.com/thymeleaf-in-spring-mvc#:~:text=Handling%20User%20Input&text=The%20th%3Aaction%20is%20used,matching%20property%20of%20the%20object.
