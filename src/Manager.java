import java.text.DecimalFormat;
import java.util.Scanner;

public class Manager extends Staff implements ICalculator{
    private String chucDanh;

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public Manager(String maNV, String tenNV, int tuoiNV, double heSoLuong, String ngayVaoLam, String boPhan, int soNgayNghiPhep, String chucDanh) {
        super(maNV, tenNV, tuoiNV, heSoLuong, ngayVaoLam, boPhan, soNgayNghiPhep);
        this.chucDanh = chucDanh;
    }

    public Manager() {
    }

    @Override
    public void displayInformation() {
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.printf("%-15s| %-25s| %-10s| %-15s| %-18s| %-23s| %-18s| %-30s| %-25s\n", getMaNV(),
                getTenNV(), getTuoiNV(), getHeSoLuong(), getNgayVaoLam(), getBoPhan(), getSoNgayNghiPhep(), chucDanh, df.format(calculateSalary()));
    }


    @Override
    public double calculateSalary() {
        double luongTrachNhiem = 0;
        if (getChucDanh() == "Business Leader") {
            luongTrachNhiem = 8000000;
        } else if (getChucDanh() == "Project Leader") {
            luongTrachNhiem = 5000000;
        } else if (getChucDanh() == "Technical Leader") {
            luongTrachNhiem = 6000000;
        }
        double salary = getHeSoLuong() * 5000000 + luongTrachNhiem;
        return salary;
    }

}
