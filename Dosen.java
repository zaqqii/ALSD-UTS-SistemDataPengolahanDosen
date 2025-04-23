
class Dosen {
    String nidn;
    String nama;
    String email;
    int tahunMasuk;
    String prodi;

    public Dosen(String nidn, String nama, String email, int tahunMasuk, String prodi) {
        this.nidn = nidn;
        this.nama = nama;
        this.email = email;
        this.tahunMasuk = tahunMasuk;
        this.prodi = prodi;
    }

    public int hitungMasaKerja() {
        return 2025 - tahunMasuk;
    }

    public String toString() {
        return "NIDN: " + nidn + ", Nama: " + nama + ", Email: " + email +
               ", Tahun Masuk: " + tahunMasuk + ", Prodi: " + prodi +
               ", Masa Kerja: " + hitungMasaKerja() + " tahun";
    }
}
