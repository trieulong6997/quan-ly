import java.text.DecimalFormat;
import java.util.Scanner;

public class Employee extends Staff implements ICalculator{
    private int soGioLamThem;

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    public Employee(String maNV, String tenNV, int tuoiNV, double heSoLuong, String ngayVaoLam, String boPhan, int soNgayNghiPhep, int soGioLamThem) {
        super(maNV, tenNV, tuoiNV, heSoLuong, ngayVaoLam, boPhan, soNgayNghiPhep);
        this.soGioLamThem = soGioLamThem;
    }

    public Employee() {
    }

    @Override
    public void displayInformation() {
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.printf("%-15s| %-25s| %-10s| %-15s| %-18s| %-23s| %-18s| %-30s| %-25s\n", getMaNV(),
                getTenNV(), getTuoiNV(), getHeSoLuong(), getNgayVaoLam(), getBoPhan(), getSoNgayNghiPhep(), getSoGioLamThem(), df.format(calculateSalary()));
    }


    @Override
    public double calculateSalary() {
        double salary = getHeSoLuong() *  3000000 + soGioLamThem *200000;
        return  salary;
    }



}
