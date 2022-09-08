import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class HumanResources {
    public static void main(String[] args) {
        listStaff();
        listBoPhan();
        while (true){
            System.out.println();
            menu();
        }
    }

    static Scanner sc = new Scanner(System.in);
    //khai báo mảng để lưu thông tin nhân viên
    static ArrayList<Staff> staff = new ArrayList<Staff>();
    //khai báo mảng để lưu thông tin bộ phận
    static ArrayList<Department> departments = new ArrayList<Department>();

    //hàm menu chọn chức năng
    public static void menu() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm nhân viên theo tên nhân viên hoặc mã nhân viên.");
        System.out.println("0. Thoát chương trình.");

        int choose;
        do {
            try {
                System.out.print("Lựa chọn của bạn: ");
                choose = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                choose =-1;
                System.out.println("Bạn nhập sai vui lòng nhập lại: ");
            }
        }while (choose <0 || choose > 7);



        switch (choose) {
            case 1:
                showAll();
                break;
            case 2:
                showDepartment();
                break;
            case 3:
                showEmployeeByDepartment();
                break;
            case 4:
                addNewEmployee();
                break;
            case 5:
                findByNameOrId();
                break;
            case 0:
                System.out.println("Bạn đã thoát chương trình.");
                System.exit(0);

        }

    }

    //hàm hiển thị tất cả nhân viên
    private static void showAll() {
        System.out.println("Danh sách nhân viên công ty: ");
        System.out.printf("%-15s| %-25s| %-10s| %-15s| %-18s| %-23s| %-18s| %-30s| %-25s\n", "Mã nhân viên", "Tên nhân viên",
                "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận", "Ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (Staff x: staff) {
            x.displayInformation();
        }
    }

    //hàm hiển thị bộ phận
    private static void showDepartment() {
        System.out.printf("%-15s | %-25s | %-20s\n", "Mã Bộ Phận", "Tên Bộ Phận", "Số Lượng Nhân viên hiện tại");
        System.out.println("--------------------------------------------------");
        for (Department x: departments) {
            System.out.print(x);
        }
    }
    //hàm hiển thị nhân viên theo bộ phận
    private static void showEmployeeByDepartment() {

        for (Department x: departments){
            System.out.println(x.getTenBoPhan());
            System.out.println("------------------------------------");
            System.out.printf("%-15s| %-25s| %-10s| %-15s| %-18s| %-23s| %-18s| %-30s| %-25s\n", "Mã nhân viên", "Tên nhân viên",
                    "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận", "Ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
            for (Staff y: staff) {
                if (y.getBoPhan().equals(x.getTenBoPhan())) {
                    y.displayInformation();
                }
            }
            System.out.println();
        }
    }

    //hàm thêm nhân viên mới
    private static void addNewEmployee() {
        Employee newEmployee = new Employee();
        Manager newManager = new Manager();
        System.out.println("1. Nhập dữ liệu nhân viên.");
        System.out.println("2. Nhập dữ liệu Quản lý.");
        int choose = Integer.parseInt(sc.nextLine());
        while (choose < 1 || choose > 2){
            System.out.print("chọn lại:");
            choose = Integer.parseInt(sc.nextLine());
        }
        //Nhập dữ liệu nhân viên
        if (choose ==1) {
            System.out.println("Nhập dữ liệu Nhân viên");
            System.out.println("---------------------------");
            System.out.print("Nhập mã Nhân viên:");
            newEmployee.setMaNV(sc.nextLine());
            System.out.println("Nhập tên Nhân viên");
            newEmployee.setTenNV(sc.nextLine());
            System.out.println("Nhập tuổi");
            newEmployee.setTuoiNV(Integer.parseInt(sc.nextLine()));
            System.out.println("Nhập hệ số lương");
            newEmployee.setHeSoLuong(Double.parseDouble(sc.nextLine()));
            System.out.println("Nhập Ngày vào làm");
            newEmployee.setNgayVaoLam(sc.nextLine());
            System.out.println("Nhập Bộ Phận");
            System.out.println("1. Hành chính nhân sự");
            System.out.println("2. Công Nghệ Thông Tin");
            System.out.println("3. Marketing");
            System.out.print("Bạn chọn: ");
            int chon = Integer.parseInt(sc.nextLine());
            while (chon<1 || chon>3) {
                System.out.println("Bạn chọn sai vui lòng chọn lại");
                chon = Integer.parseInt(sc.nextLine());
            }
            if (chon == 1){
                System.out.println("Bộ phận làm việc: Hành chính Nhân sự");
                newEmployee.setBoPhan("Hành Chính Nhân Sự");
            }else if (chon == 2) {
                System.out.println("Bộ phận làm việc: Công Nghệ Thông tin");
                newEmployee.setBoPhan("Công Nghệ Thông Tin");
            }else {
                System.out.println("Bộ phận làm việc: Marketing");
                newEmployee.setBoPhan("Marketing");
            }

            System.out.println("Nhập số ngày nghỉ phép");
            newEmployee.setSoNgayNghiPhep(Integer.parseInt(sc.nextLine()));
            System.out.println("Nhập số giờ làm thêm");
            newEmployee.setSoGioLamThem(Integer.parseInt(sc.nextLine()));

            //thêm nhân viên vào trong list
            staff.add(newEmployee);
            System.out.println("Đã Thêm Nhân viên.");

        //Nhập dữ liệu Quản lý
        }else {
            System.out.println("Nhập dữ liệu Quản lý");
            System.out.println("---------------------------");
            System.out.print("Nhập mã Nhân viên:");
            newManager.setMaNV(sc.nextLine());
            System.out.println("Nhập tên Nhân viên");
            newManager.setTenNV(sc.nextLine());
            System.out.println("Nhập tuổi");
            newManager.setTuoiNV(Integer.parseInt(sc.nextLine()));
            System.out.println("Nhập hệ số lương");
            newManager.setHeSoLuong(Double.parseDouble(sc.nextLine()));
            System.out.println("Nhập Ngày vào làm");
            newManager.setNgayVaoLam(sc.nextLine());
            System.out.println("Nhập Bộ Phận");
            System.out.println("1. Hành chính nhân sự");
            System.out.println("2. Công Nghệ Thông Tin");
            System.out.println("3. Marketing");
            System.out.print("Bạn chọn: ");
            int chon = Integer.parseInt(sc.nextLine());
            while (chon<1 || chon>3) {
                System.out.println("Bạn chọn sai vui lòng chọn lại");
                chon = Integer.parseInt(sc.nextLine());
            }
            if (chon == 1){
                System.out.println("Bộ phận làm việc: Hành chính Nhân sự");
                newManager.setBoPhan("Hành Chính Nhân Sự");
            }else if (chon == 2) {
                System.out.println("Bộ phận làm việc: Công Nghệ Thông tin");
                newManager.setBoPhan("Công Nghệ Thông Tin");
            }else {
                System.out.println("Bộ phận làm việc: Marketing");
                newManager.setBoPhan("Marketing");
            }
            System.out.println("Nhập số ngày nghỉ phép");
            newManager.setSoNgayNghiPhep(Integer.parseInt(sc.nextLine()));
            System.out.println("Nhập Chức Danh");
            System.out.println("1. Business Leader");
            System.out.println("2. Project Leader");
            System.out.println("3. Technical Leader");
            System.out.println("Bạn chọn");

            int chonCD = Integer.parseInt(sc.nextLine());
            while (chonCD<1 || chonCD>3) {
                System.out.println("Bạn chọn sai vui lòng chọn lại");
                chonCD = Integer.parseInt(sc.nextLine());
            }
            if (chonCD == 1) {
                System.out.println("Chức danh: Business Leader");
                newManager.setChucDanh("Business Leader");
            } else if (chonCD ==2) {
                System.out.println("Chức danh: Project Leader");
                newManager.setChucDanh("Project Leader");
            }else {
                System.out.println("Chức danh: Technical Leader");
                newManager.setChucDanh("Technical Leader");
            }
            staff.add(newManager);

        }

    }

    //hàm tìm kiếm nhân viên theo tên hoặc mã nhân viên
    private static void findByNameOrId() {
        System.out.println("1.Tìm bằng mã Nhân viên");
        System.out.println("2.Tìm bằng tên Nhân viên");
        int choose = Integer.parseInt(sc.nextLine());
        while (choose < 1 || choose > 2) {
            System.out.println("bạn chọn sai vui lòng chọn lại");
            choose = Integer.parseInt(sc.nextLine());
        }
        //tim kiem bang ma nv
        if (choose == 1) {
            System.out.println("Nhập mã Nhân viên");
            String findByID = sc.nextLine();
            for (Staff x: staff) {
                if (findByID.equalsIgnoreCase(x.getMaNV())) {
                    System.out.println("Đã tìm thấy Nhân viên:" + findByID);
                    System.out.printf("%-15s| %-25s| %-10s| %-15s| %-18s| %-23s| %-18s| %-30s| %-25s\n", "Mã nhân viên", "Tên nhân viên",
                            "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận", "Ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                    System.out.println("--------------------------------------------------------------------------------------" +
                            "----------------------------------------------------");
                    x.displayInformation();
                }
            }
        //tim kiem bang ten nhan vien
        }else {
            System.out.println("nhap ten nhan vien");
            String find = sc.nextLine();
            for (Staff x: staff) {
                if (x.getTenNV().toLowerCase().contains(find.toLowerCase())) {
                    System.out.println("da tim thay nv" + find);
                    System.out.printf("%-15s| %-25s| %-10s| %-15s| %-18s| %-23s| %-18s| %-30s| %-25s\n", "Mã nhân viên", "Tên nhân viên",
                            "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận", "Ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                    System.out.println("--------------------------------------------------------------------------------------" +
                            "----------------------------------------------------");
                    x.displayInformation();
                }
            }
        }
    }

    //hàm tạo danh sách nhân viên và quản lý
    static void listStaff() {
        //tạo danh sách nhân viên
       Employee nv1 = new Employee("cn001","Nguyễn Bảo Huy",
               21,4.2,"20/11/2020","Công Nghệ Thông Tin",2, 10);

       Employee nv2 = new Employee("mk001","Tạ Công Minh",
               23,5.3,"12/03/2021","Marketing",5, 8);

        Employee nv3 = new Employee("hc001","Đinh Văn Hải",
                21,4.6,"06/08/2021","Hành Chính Nhân Sự",1, 13);

        Employee nv4 = new Employee("cn002","Trần Xuân Đức",
                23,5.3,"22/12/2022","Công Nghệ Thông Tin",3, 20);

        //tạo danh sách quản lý
        Manager ql1 = new Manager("ld001","Dương Nam Khánh",
                23,8.1,"14/01/2020","Công Nghệ Thông Tin",1, "Technical Leader");

        Manager ql2 = new Manager("ld002","Ngô Tạ Gia Phát",
                23,7.6,"24/05/2021","Marketing",5, "Project Leader");

        Manager ql3 = new Manager("ld003","Dương Nam Khánh",
                23,6.8,"14/01/2020","Hành Chính Nhân Sự",2, "Business Leader");

        //thêm nhân viên và quả lý vào mảng
        staff.add(nv1);
        staff.add(nv2);
        staff.add(nv3);
        staff.add(nv4);
        staff.add(ql1);
        staff.add(ql2);
        staff.add(ql3);

    }
    //hàm tạo bộ phận
    static void listBoPhan() {
        Department bp1 = new Department("IT","Công Nghệ Thông Tin",3);
        Department bp2 = new Department("MKT","Marketing",2);
        Department bp3 = new Department("HC","Hành Chính Nhân Sự",2);
        //thêm bộ phận vào mảng
        departments.add(bp1);
        departments.add(bp2);
        departments.add(bp3);

    }


}

