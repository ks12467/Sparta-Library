import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book() {

    }

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


    //책 제목 조회 equals book title
    public void findNameBook() {
        System.out.println("책 제목을 조회합니다.");
        String bookName = scanner.nextLine();
        if (this.title.equals(bookName)) {
            this.getTitle();
            System.out.println(this.getTitle() + " 제목의 책이 존재합니다.");
        } else {
            System.out.println(bookName + " 제목의 책이 존재하지 않습니다.");
        }
    }

    //책 대여여부 조회 isAvailable
    public void isAvailableBook(Book book) {
        System.out.println("책 대여 여부를 조회합니다.");
        String bookName = scanner.nextLine();
        if (this.title.equals(bookName)) {
            this.getTitle();
            if (this.isAvailable() == true) {
                System.out.println(bookName + "제목의 책은 대여 가능합니다.");
            } else {
                System.out.println(bookName + "의 책은 이미 대여되었습니다.");

            }
        }
    }

    //책 대여여부 설정 library / rent
    public Boolean setIsAvailableBook(Book book) {
        System.out.println("책의 대여 상태를 변경합니다");
        String bookName = scanner.nextLine();
        if (this.title.equals(bookName)) {
            this.getTitle();
            if (this.isAvailable() == true) {
                System.out.println(bookName + " 제목의 책을 대여 상태로 바꾸시겠습니까?(y/n");
                String available = scanner.nextLine();
                if (available.equals("y")) {
                    isAvailable = false;
                    System.out.println(bookName + " 제목의 책은 대여중 상태로 변경되었습니다.");
                } else {
                    isAvailable = true;
                    System.out.println(bookName + " 제목의 책은 변경되지 않았습니다");
                }
            } else if (this.isAvailable() == false) {
                System.out.println(bookName + "제목의 책을 반납 완료 상태로 바꾸시겠습니까?(y/n)");
                String available = scanner.nextLine();
                if (available.equals("y")) {
                    isAvailable = true;
                    System.out.println(bookName + " 제목의 책은 반납되었습니다");
                } else {
                    isAvailable = false;
                    System.out.println(bookName + " 제목의 책은 변경되지 않았습니다");
                }
            }
        }
        return isAvailable;
    }


    // 책 상세 정보 출력 book info
    public String bookInfo() {
        System.out.println("정보를 확인할 책의 제목을 입력하세요.");
        String bookName = scanner.nextLine();
        if (this.title.equals(bookName)) {
            System.out.println(bookName + "제목의 책이 확인되었습니다.");
            String available = isAvailable() ? "대여 가능" : "대여 중";
            return "제목: " + getTitle() + "\n저자: " + getAuthor() + "\n대여 여부" + isAvailable();
        } else {
            System.out.println(bookName + "제목의 책을 확인할 수 없습니다.");
        }
        return null;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    Scanner scanner = new Scanner(System.in);

    //클래스 생성자:
    //제목
    //저자
    //대여여부
}