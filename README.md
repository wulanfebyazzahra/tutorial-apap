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

 ---
## Tutorial 5

1. Apa itu Postman? Apa kegunaannya?

**Jawab**:
Postman merupakan sebuah aplikasi yang berfungsi sebagai REST Client untuk melakukan uji REST API. Postman juga merupakan *tool* yang digunakan untuk melakukan proses development API, dimana biasanya akan digunakan oleh developer sebagai *tools* untuk menguji API yang telah dibuat. Ada pun beberapa kegunaan dari Postman, yaitu:

 - **Collection**: Pengelompokan request API yang bisa disimpan atau diatur dalam bentuk folder.
 - **Environment**: Config untuk menyimpan attribute dan attribute tersebut dapat digunakan ataupun dimanipulasi dalam proses request API.
 - **Response**: Dengan menggunakan response developer dapat membuat Mockup API sebelum benar-benar mengimplementasikan ke dalam proyek.
 - **Mock Server**: Dengan menggunakan fitur ini mockup API yang dibuat menggunakan fitur “example response” dapat diakses dari internet selayaknya Mockup API tersebut sudah di implementasikan dan di deploy ke server.
 - **Script Test**: Fitur untuk melakukan validasi respon, selain itu di dalamnya dapat menuliskan test sesuai dengan kebutuhan.
 - **Automated Test**: Dengan menggunakan *script test*, request dalam satu collection dapat dijalankan secara otomatis.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.

**Jawab**:
 - Fungsi dari @JsonIgnoreProperties adalah untuk mengabaikan properti logika pada serialisasi dan deserialiasi JSON. @JsonIgnoreProperties memiliki elemen allowGetters, allowSetters, ignoreUnkown, dan value. Elemen ini memiliki fungsi untuk menentukan nama properti yang akan diabaikan pada kelas.

 - Fungsi dari @JsonProperty adalah untuk memetakan nama properti dengan kunci JSON selama serialisasi dan deserialisasi. @JsonProperty dapat digunakan pada kondisi saat deserialisasi dimana nama properti JSON dan nama field dari objek Java tidak sesuai.

3. Apa kegunaan atribut WebClient?

**Jawab**:
WebClient adalah higher-level abstraction dari HttpWebRequest yang disediakan oleh Spring Framework untuk mempermudah operasi seperti Create, Read, Update, dan Delete. Fungsi utamanya adalah untuk menginstansi sebuah akses poin URL dan juga akan mengelola request serta response dari URL tersebut.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?

**Jawab**:
 - ResponseEntity merupakan sesuatu yang merepresentasikan keseluruhan HTTP response, mulai dari status code, headers, and body. Sebagai hasilnya, kita bisa menggunakannya untuk melakukan konfigurasi keseluruhan terhadap HTTP response. 


 - BindingResult merupakan objek yang dimiliki oleh Spring, dimana objek tersebut akan menyimpan hasil dari validasi dan binding. Selain itu akan menyimpan error-error yang mungkin terjadi. BindingResult harus datang langsung setelah objek model sudah tervalidasi, jika tidak maka Spring akan gagal melakukan validasi terhadap objek dan akan melakukan throw exception.


### Sources:
 - https://medium.com/@novancimol12/postman-4f181d625fe1#:~:text=Postman%20merupakan%20tool%20untuk%20melakukan,Collection
 - https://wirasetiawan29.wordpress.com/2015/04/16/webclient-vs-httpclient/
 - https://www.baeldung.com/spring-response-entity
 - https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc#:~:text=%5B%20BindingResult%20%5D%20is%20Spring's%20object%20that,object%20and%20throw%20an%20exception.w

---
## Tutorial 6

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?

**Jawab**:
Otentikasi adalah sebuah proses untuk memverifikasi apakah user yang sedang melakukan login dengan username yang dituju telah terdaftar di database. Otorisasi adalah sebuah proses untuk menentukan apakah user memiliki hak untuk mengakses ke halaman tertentu yang telah di otentikasi.
 
 - Contoh implementasi otentikasi pada class `WebSecurityConfig`:
    @Autowired
        public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{auth.userDetailsService(userDetailsService).passwordEncode(encoder());}

 - Contoh implementasi otorisasi pada class `WebSecurityConfig`:
        .authorizeRequests()
        .antMatchers("/css/**").permitAll()
        .antMatchers("/js/**").permitAll()
        .antMatchers("/hotel/**").hasAuthority("RECEPTIONIST")
        .antMatchers("/kamar/add/**").hasAuthority("RECEPTIONIST")

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.

**Jawab**:
BCryptPasswordEncoder adalah salah satu fungsi password hashing yang berfungsi untuk melakukan enkripsi kata sandi user sebelum disimpan ke database. BCryptPasswordEncoder juga berfungsi untuk melakukan enkripsi terhadap kata sandi pada saat user ingin melakukan login. 

3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!

**Jawab**:
UUID (Universally Unique Identifier) adalah 32 karakter string yang dibuat secara random dengan algoritma tertentu. UUID meningkatkan keamanan data user karena id pengguna akan di generate secara unique dengan hashing sebanyak 32 karakter secara acak sehingga id user menjadi aman dan tidak mudah untuk di hack.

4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?

**Jawab**:
Class UserDetailsServiceImpl.java berfungsi untuk mengambil informasi otentikasi dan otorisasi user. Menurut saya, harus ada Class UserDetailsImpl.java padahal kita sudah memiliki UserRoleServiceImpl.java karena class ini dapat melakukan otorisasi terhadap user yang melakukan login sesuai dengan role yang sudah terdaftar di database.

---
## Tutorial 7

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.

**Jawab**:
 - Latihan 1

 Pada latihan pertama ini, yang saya lakukan adalah menambahkan kondisi if/else. If/else tersebut berfungsi untuk mengecek apakah *checked* bernilai true, apabila bernilai true maka checkbox pun akan diperlihatkan.

```ruby
       <input
       type={checked ? "checkbox" : "hidden"}                                
       className="ml-2"
       checked={checked}
       onChange={handleChange}
       />
```

 - Latihan 2
 
 Pada latihan kedua, yang saya lakukan adalah menambah function bernama handleDeleteClick() pada App.js yang akan menghandle penghapusan list favorit apabila di klik.

 ```ruby
       handleDeleteClick = () => {
       this.setState({favItems: []
       });
       };
```
Setelah menambahkan function tersebut, selanjutnya saya akan memanggil function tersebut pada button yang saya buat. Pada button tersebut saya juga menambahkan kondisi if/else apabila list favoritnya tidak kosong maka button tersebut akan ditampilkan.

```ruby
       {!favItems.length == 0 ? (
       <div className="d-flex justify-content-center align-items-center">
       <button className="btn btn btn-outline-dark" onClick={this.handleDeleteClick}>
       Delete Favorites
       </button>
       </div>
       ) : (
       null
       )};
```
 - Latihan 3
 Pada latihan ketiga yang saya lakukan adalah mengubah function handleItemClick() menjadi handleFavoriteClick(). Kemudian saya menambah satu function lagi bernama yang sama yaitu handleItemClick(), dimana isi fungsi tersebut sama persis dengan handleFavoriteClick(), yang berbeda adalah saya menghapus kondisi else newItems.splice(targetInd, 1);

 ```ruby
       handleItemClick = item => {
       const newItems = [...this.state.favItems];
       const newItem = { ...item };

       const targetInd = newItems.findIndex(it => it.id === newItem.id);
       if (targetInd < 0) newItems.push(newItem);

       this.setState({ favItems: newItems });
       };

       handleFavoriteClick = item => {
       const newItems = [...this.state.favItems];
       const newItem = { ...item };

       const targetInd = newItems.findIndex(it => it.id === newItem.id);
       if (targetInd < 0) newItems.push(newItem);
       else newItems.splice(targetInd, 1);

       this.setState({ favItems: newItems });
       };
```

Selanjutnya pada elemen My Favorites saya mengubah onItemClick yang tadinya this.handleItemClick menjadi this.handleFavoriteClick.

 ```ruby
       <div className={`col-sm ${textDisplay ? "d-block" : "d-none"}`}>
       <List
              title="My Favorites"
              items={favItems}
              onItemClick={this.handleFavoriteClick}
       />
       </div>
```

 - Latihan 4
 Pada latihan keempat untuk membuat toggle yang menampilkan list favorit, saya pertama-tama membuat state dengan nilai default false.

```ruby
       state = {
       favItems: [],
       textDisplay: false
       };
```

Selanjutnya saya membuat suatu function di App.js dengan nama clickToggle(), dimana function tersebut akan memberikan nilai booleann terbalik dari state yang akan masuk ke function. Function ini akan dimengaktifkan on/off dari toggle button.

```ruby
       clickToggle = () => {
       this.setState(currentState => ({
       textDisplay: !currentState.textDisplay
       }));
       };
```

Selanjutnya pada App.js saya menambahkan toggle yang akan mengaktifkan function clickToggle()

```ruby
       <input 
       type="checkbox" 
       onClick={this.clickToggle} />
       <span className="slider round"></span>
       </label>
```
Lalu saya menambahkan kondisi if/else apabila toggle bernilai false tidak akan menampilkan list film favorit. Namun sebaliknya, jika toggle bernilai true maka list favorit akan ditampilkan.

```ruby
       <div className={`col-sm ${textDisplay ? "d-block" : "d-none"}`}>
       <List
              title="My Favorites"
              items={favItems}
              onItemClick={this.handleFavoriteClick}
       />
       </div>
```

 - Latihan 5
 
 Pada latihan kelima, yang saya lakukan adalah menambahkan component baru bernama EmptyState. Di dalamnya saya memasukkan suatu index.js yang berisi function EmptyState. Kemudian pada List/index.js yang saya lakukan adalah menambahkan kondisi if/else, dimana apabila list favorit tidak kosong, maka list favorit pun akan ditunjukkan. Sebaliknya jika list favorit kosong maka akan ditamplkan empty state yang telah saya buat tadi di component yang baru.

```ruby
       export default function EmptyState() {
       return (
       <>
       <h3 className="text-center">Belum ada item yang dipilih</h3>
       <p className="text-center">Klik salah satu item di List Movies</p>
       </>
       );
       }
```

```ruby
      {items.length !== 0 ? (
        <div className="list-group">
          {items.map(item => (
            <Item key={item.id} item={item} onChange={onItemClick} />
          ))}
        </div>
      ) : (
        <EmptyState />
      )}
```

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?

**Jawab**:
Props atau property merupakan suatu parameter dalam functional components, dimana props ini dapat diakses pada suatu kelas atau function dengan menggunakan "this". Property ini mirip seperti atribut pada tag HTML. Sedangkan State merupakan data private dari sebuah component yang tidak bisa diakses oleh komponen lainnya. Nantinya komponen akan menetapkan default value dari state. State ini nanti bisa dipakai untuk menyimpan atau mendeklarasi suatu objek yang kita inginkan.

3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!

**Jawab**:
Sebelum mengetahui kelebihan dari component, definisi dari component sendiri merupakan bagian-bagian kecil dari suatu aplikasi. Dimana komponen ini nantinya adapat digunakan menjadi sebuah aplikasi. Keuntungan yang didapatkan apabila menggunakan component adalah component bersifat reusable, sehingga dapat digunakan kembali. Selain itu dengan menggunakan component kode yang kita buat juga menjadi lebih rapih, mudah dipahami, dan mudah diaksesnya. Sehingga jika bertemu dengan error akan lebih mudah untuk diperbaikinya. Contoh implementasinya adalah pada tutorial dan latihan kita memisahkan component List dan Item, dimana List akan dipergunakan untuk mengelola list film favorit, sedangkan Item akan digunakan untuk mengelola list film. Dapat dilihat dengan memisahkan keduanya, kodingan yang dibuat akan menjadi lebih rapih dan mudah diakses apabila terdapat kesalahan.

4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?

**Jawab**:
Berikut ini merupakan kelebihan dan keuntungan yang mungkin didapatkan apabila menggunakan React, yaitu:
 - Kemudahan dalam menulis komponennya.
 - Proses rendering jauh lebih cepat karena adanya virtual DOM.
 - Kode yang dibangun terjamin kestabilannya.
 - SEO friendly.
 - Komponen-komponen yang dapat digunakan kembali.
 - Mudah dipelajari.
 - Dapat digunakan dalam pengembangan aplikasi.

5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?

**Jawab**:
Berikut ini merupakan kekurangan dalam menggunakan React dalam pengembangan web:
 - Laju pembangunan yang tinggi, karena sering terjadinya perubahan yang dengan cepat terjadi.
 - Dokumentasi yang buruk.
 - React hanya mencakup lapisan UI aplikasi dan tidak ada yang lain.
 - Pada browser versi lama tidak mendukung React.

### Sources:
 - https://medium.com/coderupa/react-prop-state-apa-bedanya-7ee61df8257f
 - https://www.techfor.id/10-keuntungan-menggunakan-react-js-pada-desain-website/#:~:text=Manfaat%20lain%20React%20js%20adalah,browser%20sebagai%20laman%20web%20biasa.
 - konsepkoding.com/2020/08/1-pengenalan-reactjs-kekurangan-dan.html
 - https://belajarreactjs.com/kelemahan-dari-reactjs/

---
## Tutorial 8

1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?

**Jawab**:
Untuk menyelesaikan masalah yang terjadi pada latihan nomor 1, langkah yang saya lakukan adalah menambahkan this.setState pada handleAddHotel(). Dimana di dalamnya saya menambahkan value kosong ("") untuk namaHotel, alamat, serta nomorTelepon. Setelah saya meletakan state tersebut maka yang akan terjadi adalah default value pada form saat melakukan penambahan hotel akan selalu ketika ingin diisi.

```ruby
this.setState({
       namaHotel: "",
       alamat: "",
       nomorTelepon: "",
})
```

2. Jelaskan fungsi dari async dan await!

**Jawab**:
Fungsi dari async adalah untuk menandakan fungsi yang dibuat bersifat asinkron atau non-blocking. Fungsi dari await adalah untuk menangani proses asinkron yang sedang running hingga selesai sebelum code setelah await dijalankan. Implementasi async dan await di tutorial 8 ini ada di class HotelList, salah satu contohnya adalah method loadData, yaitu:

```ruby
async loadData(){
       try{
              const {data} = await APIConfig.get("/hotels");
              this.setState({hotels: data});
       }catch(error){
              alert("Ooops terjadi masalah pada server");
              console.log(error);
       }
}
```

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 7 pada Component Lifecycle pada pertanyaan ini.

**Jawab**:

![Screenshot 1](https://i.ibb.co/fD1N1W5/Screen-Shot-2020-12-10-at-10-49-38-AM.png)

![Screenshot 2](https://i.ibb.co/FmKQF7t/Screen-Shot-2020-12-10-at-10-49-57-AM.png)

![Screenshot 3](https://i.ibb.co/R7v8HZN/Screen-Shot-2020-12-10-at-10-53-37-AM.png)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.

**Jawab**:

 - **componentDidMount**: Melakukan fetching data setelah component telah selesai melakukan render.

 - **shouldComponentUpdate**: Memiliki 2 parameter (nextProps dan nextState) dan dijalankan sebelum component melakukan render ulang terhadap perubahan yang terjadi. Component akan di render ulang jika return nya adalah true, jika false component tidak akan di render ulang.

 - **componentDidUpdate**: Menerima 2 parameter (prevProps dan prevState), dijalankan setelah component yang di render ulang (diupdate) sudah selesai di render dan digunakan saat melakukan interaksi dengan environment non React.

 - **componentWillReceiveProps**: Dijalankan sebelum component mengisi props yang baru dan mengalami pembaruan untuk membandingkan props yang ada dengan yang baru dan juga untuk memeriksa apakah terdapat perubahan yang terjadi dengan props tersebut.

 - **componentWillUnmount**: Dijalankan sebelum component di hapus dari DOM dan melakukan cleanup seperti membatalkan network request dan menghilangkan event listener.

### Sources:
 - https://id.reactjs.org/docs/react-component.html
 - https://www.w3schools.com/react/react_lifecycle.asp
 - https://www.valentinog.com/blog/await-react/