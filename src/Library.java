import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Book> libraryList = new ArrayList<Book>();


    //생성자 : 책 목록 초기화 필요
    public Library() {

        bookList = new ArrayList<>();
    }

    public String createBook() {
        System.out.println("등록할 책의 제목을 입력해주세요:");
        String title = scanner.nextLine();

        System.out.println("등록할 책의 저자를 입력해주세요:");
        String author = scanner.nextLine();

        System.out.println("책을 등록하는 중...");

        // Book 객체 생성 후 Library 클래스의 bookList에 추가
        Book book = new Book(title, author, true);
        bookList.add(book);

        System.out.println("책이 성공적으로 등록되었습니다.");
        return book.toString();
    }

    //메서드 : 도서관에 책 추가.
    public void addBookLibrary() {
        System.out.println("도서관에 추가할 수 있는 책 목록");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println((i + 1) + ". " + bookList.get(i).getTitle());
        }
        //입력 값을 받아서 도서관 클래스에 저장
        System.out.println("어떤 책을 도서관에 추가하시겠습니까?");
        String bookName = scanner.nextLine();

        boolean find = false;
        for (Book book : bookList) {
            if (book.getTitle().equals(bookName)) {
                libraryList.add(book);
                System.out.println(book.getTitle() + " 제목의 책이 도서관에 추가되었습니다.");
                find = true;
                break;
            }
        }

        if (!find) {
            System.out.println(bookName + "제목의 책을 찾을 수 없습니다");
        }
    }


    // 책 이름으로 조회,
    public void findbyName() {
        System.out.println("찾으실 책 제목을 입력해주세요.");
        String bookName = scanner.nextLine();

        if (!libraryList.isEmpty()) {
            for (Book book : bookList) {
                if (book.getTitle().equals(bookName)) {
                    System.out.println(book.bookInfo());
                } else {
                    System.out.println("책 제목이 일치하지 않습니다.");
                }
            }
        } else {
            System.out.println("도서관에 등록된 책이 없습니다.");
        }
    }

    // 모든 책 조회,
    public void findAllBook() {
        System.out.println("도서관에 등록되어 있는 책 목록을 전부 찾으시겠습니까?(y/n)");
        String str = scanner.nextLine();
        if (str.equals("y")) {
            if (!libraryList.isEmpty()) {
                System.out.println("도서관에 등록되어 있는 책 목록입니다.");
                System.out.println(libraryList.toString());
            } else {
                System.out.println("도서관에 등록되어 있는 책이 없습니다.");
            }
        } else if (str.equals("n")) {
            System.out.println("메인 화면으로 돌아갑니다.");
        } else {
            System.out.println("입력 값이 올바르지 않습니다.");
            System.out.println("메인 화면으로 돌아갑니다.");
        }
    }

    // 도서관에 책 제거,
    public void deleteBookLibrary() {
    }


    // 책 대여
    public void rentBook() {
    }

    // 책 반납
    public void returnBook() {
    }

}