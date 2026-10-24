<h1 align="center">Tugas Praktikum 4 - Polimorfisme, Abstract, dan Interface</h1>
<p align="center">
 <img width="286" height="286" alt="image" src="https://github.com/user-attachments/assets/5e2ec322-9379-4ad8-91be-de301db61dff"/><br>
  <b>Nama: Hanung Yoga Adi Pramono<br>
  NIM: L0325026</b>
</p>

## Penjelasan source code

## Kegiatan 1

### Hewan.java
```java
package praktikum8;

public class Hewan {
    public void bersuara() {
        System.out.println("Hewan ini mengeluarkan suara yang tidak spesifik.");
    }
}
```
Kode tersebut merupakan class Hewan yang digunakan sebagai class induk atau superclass. Di dalamnya terdapat method bersuara() yang berfungsi menampilkan suara hewan secara umum. Method ini nantinya dapat diwariskan oleh class lain, seperti Kucing dan Anjing. Dengan adanya class induk, beberapa class hewan dapat menggunakan nama method yang sama, tetapi memiliki perilaku yang berbeda.

### Kucing.java
```java
package praktikum8;

public class Kucing extends Hewan {
    @Override
    public void bersuara() {
        System.out.println("Kucing: Meow meow!");
    }
}
```
Class Kucing merupakan turunan dari class Hewan karena menggunakan kata kunci extends. Class ini memiliki method bersuara() yang menampilkan suara khas kucing. Anotasi @Override digunakan untuk menandakan bahwa method tersebut menggantikan implementasi method bersuara() dari class induknya. Dengan begitu, ketika method ini dipanggil pada objek Kucing, program akan menampilkan suara kucing, bukan suara hewan secara umum.

### Anjing.java
package praktikum8;
```java
public class Anjing extends Hewan {
    @Override
    public void bersuara() {
        System.out.println("Anjing: Guk guk!");
    }
}
```
Class Anjing juga merupakan turunan dari class Hewan. Sama seperti class Kucing, class ini menggunakan method bersuara() yang sudah disesuaikan dengan karakteristik anjing. Perbedaannya terletak pada hasil output yang ditampilkan, yaitu suara "Guk guk!". Kode ini menunjukkan konsep pewarisan atau inheritance, yaitu class anak dapat mewarisi struktur dari class induk dan menyesuaikan perilakunya sendiri.

### PoliTester.java
```java
package praktikum8;

public class PoliTester {
    public static void main(String[] args) {
        Hewan[] daftarHewan = new Hewan[3];

        daftarHewan[0] = new Hewan();
        daftarHewan[1] = new Kucing();
        daftarHewan[2] = new Anjing();

        for (Hewan h : daftarHewan) {
            h.bersuara();
        }
    }
}
```
Class PoliTester digunakan untuk menjalankan dan menguji konsep polimorfisme pada program. Array daftarHewan dibuat dengan tipe Hewan, tetapi dapat menampung objek dari class Hewan, Kucing, dan Anjing. Selanjutnya, perulangan for-each digunakan untuk memanggil method bersuara() pada setiap objek di dalam array. Walaupun method yang dipanggil memiliki nama yang sama, hasilnya berbeda sesuai dengan jenis objeknya. Hal tersebut merupakan contoh polimorfisme, yaitu satu method dapat memiliki perilaku yang berbeda berdasarkan objek yang menjalankannya.

## Penjelasan Output
```
Hewan ini mengeluarkan suara yang tidak spesifik.
Kucing: Meow meow!
Anjing: Guk guk!
```
Output tersebut menunjukkan bahwa method bersuara() menghasilkan keluaran yang berbeda sesuai dengan objek yang dijalankan. Pada objek Hewan, program menampilkan "Hewan ini mengeluarkan suara yang tidak spesifik." karena menggunakan method asli dari class Hewan yang menampilkan suara secara umum. Pada objek Kucing, program menampilkan "Kucing: Meow meow!" karena class Kucing melakukan override terhadap method bersuara() untuk menampilkan suara khas kucing. Sementara itu, objek Anjing menampilkan "Anjing: Guk guk!" karena class Anjing juga melakukan override untuk menampilkan suara khas anjing. Perbedaan output tersebut merupakan contoh polimorfisme, yaitu penggunaan method dengan nama yang sama, tetapi menghasilkan perilaku berbeda sesuai dengan jenis objeknya.

## Kegiatan 2

### AlatElektronik.java
```java
package praktikum8;

public interface AlatElektronik {
    void nyalakan();
    void matikan();
}
```
Kode tersebut merupakan interface AlatElektronik yang berfungsi sebagai aturan dasar bagi class yang mengimplementasikannya. Di dalam interface terdapat dua method, yaitu nyalakan() untuk menyalakan alat elektronik dan matikan() untuk mematikannya. Kedua method tersebut belum memiliki isi sehingga harus diimplementasikan oleh class yang menggunakan interface ini. Dengan adanya interface, setiap class yang menerapkannya harus menyediakan fungsi untuk menyalakan dan mematikan perangkat elektronik.

### Kamera.java
```java
package praktikum8;

public interface Kamera {
    void ambilFoto();
}
```

Kode tersebut merupakan interface Kamera yang mendefinisikan kemampuan untuk mengambil foto. Di dalamnya terdapat method ambilFoto() yang belum memiliki isi. Class yang mengimplementasikan interface ini harus membuat isi dari method tersebut sesuai dengan fungsi yang dibutuhkan. Pada program ini, interface Kamera digunakan oleh class Smartphone agar smartphone memiliki kemampuan untuk mengambil foto.

### Smartphone.java
```java
package praktikum8;

public class Smartphone implements AlatElektronik, Kamera {

    private String merk;

    public Smartphone(String merk) {
        this.merk = merk;
    }

    @Override
    public void nyalakan() {
        System.out.println(merk + " menyala. Booting OS...");
    }

    @Override
    public void matikan() {
        System.out.println(merk + " dimatikan. Goodbye.");
    }

    @Override
    public void ambilFoto() {
        System.out.println("Cekrek! Foto berhasil disimpan di galeri " + merk + ".");
    }
}
```

Class Smartphone mengimplementasikan dua interface, yaitu AlatElektronik dan Kamera, menggunakan kata kunci implements. Variabel merk digunakan untuk menyimpan nama merek smartphone, sedangkan constructor Smartphone(String merk) digunakan untuk memberikan nilai merek ketika objek dibuat. Method nyalakan() menampilkan pesan saat smartphone dinyalakan, method matikan() menampilkan pesan saat smartphone dimatikan, dan method ambilFoto() menampilkan pesan ketika foto berhasil disimpan. Anotasi @Override digunakan untuk menandakan bahwa method tersebut merupakan implementasi dari method yang telah didefinisikan dalam interface.

### MainKegiatan2.java
```java
package praktikum8;

public class MainKegiatan2 {
    public static void main(String[] args) {
        Smartphone hp = new Smartphone("Samsung");

        hp.nyalakan();
        hp.ambilFoto();
        hp.matikan();
    }
}
```

Class MainKegiatan2 digunakan sebagai program utama untuk menjalankan dan menguji fungsi dari class Smartphone. Method main() merupakan titik awal ketika program dijalankan. Pada bagian new Smartphone("Samsung"), dibuat objek smartphone dengan merek Samsung. Selanjutnya, method nyalakan(), ambilFoto(), dan matikan() dipanggil secara berurutan untuk menampilkan proses menyalakan smartphone, mengambil foto, dan mematikan smartphone.

## Penjelasan Output
```
Samsung menyala. Booting OS...
Cekrek! Foto berhasil disimpan di galeri Samsung.
Samsung dimatikan. Goodbye.
```

Output pertama menunjukkan bahwa smartphone Samsung berhasil dinyalakan melalui method nyalakan(), yang menampilkan pesan proses menjalankan sistem operasi. Output kedua menunjukkan bahwa method ambilFoto() dijalankan dan menampilkan pesan bahwa foto berhasil disimpan di galeri Samsung. Output ketiga menunjukkan bahwa method matikan() dipanggil untuk menampilkan pesan bahwa smartphone dimatikan. Urutan output tersebut sesuai dengan urutan pemanggilan method di dalam class MainKegiatan2. Program ini menunjukkan penerapan interface, yaitu satu class dapat mengimplementasikan beberapa interface untuk memiliki kemampuan yang berbeda.

## Kegiatan3

### BangunDatar.java
```java
package praktikum8;

public abstract class BangunDatar {

    String warna;

    public BangunDatar(String warna) {
        this.warna = warna;
    }

    public abstract double hitungLuas();

    public void cetakWarna() {
        System.out.println("Warna bangun ini adalah: " + warna);
    }
}
```

Class BangunDatar merupakan class abstrak yang digunakan sebagai kerangka dasar bagi bangun datar lainnya. Kata kunci abstract menunjukkan bahwa class ini tidak dapat dibuat objeknya secara langsung. Variabel warna digunakan untuk menyimpan warna bangun datar, sedangkan constructor BangunDatar(String warna) digunakan untuk memberikan nilai warna. Method hitungLuas() merupakan method abstrak yang belum memiliki isi sehingga harus diimplementasikan oleh class turunannya. Sementara itu, method cetakWarna() sudah memiliki isi dan berfungsi menampilkan warna bangun datar.

### Lingkaran.java
```java
package praktikum8;

public class Lingkaran extends BangunDatar {

    private double jariJari;

    public Lingkaran(String warna, double jariJari) {
        super(warna);
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }
}
```
Class Lingkaran merupakan turunan dari class abstrak BangunDatar karena menggunakan kata kunci extends. Variabel jariJari digunakan untuk menyimpan panjang jari-jari lingkaran. Constructor menerima parameter warna dan jari-jari, sedangkan super(warna) digunakan untuk memanggil constructor dari class induk agar nilai warna dapat disimpan. Method hitungLuas() mengimplementasikan method abstrak dari BangunDatar dengan menghitung luas lingkaran berdasarkan nilai jari-jari. Kata kunci @Override menandakan bahwa method tersebut mengimplementasikan method dari class induk.

### MainKegiatan3
```java
package praktikum8;

public class MainKegiatan3 {
    public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran("Merah", 7);

        lingkaran.cetakWarna();
        System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
    }
}
```

Class MainKegiatan3 berfungsi sebagai program utama untuk menguji class Lingkaran. Pada bagian new Lingkaran("Merah", 7), dibuat objek lingkaran dengan warna merah dan panjang jari-jari 7. Selanjutnya, method cetakWarna() dipanggil untuk menampilkan warna lingkaran, sedangkan method hitungLuas() dipanggil untuk menghitung dan menampilkan luas lingkaran. Hasil perhitungan ditampilkan menggunakan System.out.println().

## PenjelasanOutput
```
Warna bangun ini adalah: Merah
Luas lingkaran: 153.93804002589985
```

Output pertama menunjukkan bahwa warna lingkaran adalah merah. Pesan tersebut ditampilkan melalui method cetakWarna() yang diwarisi dari class BangunDatar. Output kedua menunjukkan hasil perhitungan luas lingkaran dengan jari-jari 7. Program menggunakan nilai π dari Math.PI, kemudian mengalikannya dengan jari-jari sebanyak dua kali. Hasil perhitungan tersebut adalah sekitar 153,94. Banyaknya angka di belakang koma muncul karena Java menampilkan hasil perhitungan dalam tipe data double. Program ini menunjukkan penerapan abstraksi dan pewarisan, yaitu class BangunDatar menyediakan kerangka dasar, sedangkan class Lingkaran memberikan implementasi khusus untuk menghitung luas lingkaran.
