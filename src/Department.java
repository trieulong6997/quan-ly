public class Department {
    private String maBoPhan;
    private String tenBoPhan;
    private int soLuongNV;

    //constructor
    public Department() {
    }

    public Department(String maBoPhan, String tenBoPhan, int soLuongNV) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNV = soLuongNV;
    }

    //getter and setter
    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoLuongNV() {
        return soLuongNV;
    }

    public void setSoLuongNV(int soLuongNV) {
        this.soLuongNV = soLuongNV;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-25s | %-20s\n", getMaBoPhan(), getTenBoPhan(), getSoLuongNV());
    }
}
