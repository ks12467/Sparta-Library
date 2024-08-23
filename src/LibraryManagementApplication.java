import java.util.Scanner;

public class LibraryManagementApplication {
    private final LibraryContext context;

    Library library = new Library();
    Book book = new Book();
    Scanner scanner = new Scanner(System.in);

    public LibraryManagementApplication(LibraryContext context) {
        this.context = context;
    }
    //도서관 객체 생성

    public void run() {
        mainView();
    }

    public void mainView() {
        boolean flag = true;

        while (flag) {
            System.out.println("1. 책 등록");
            System.out.println("2. 도서관에 등록");
            System.out.println("3. 책 삭제");
            System.out.println("4. 책 제목으로 찾기");
            System.out.println("5. 모든 책 찾기");
            System.out.println("6. 책 대여하기");
            System.out.println("7. 책 반납하기");
            System.out.println("원하는 항목의 번호를 입력해주세요");
            int input = scanner.nextInt();

            switch (input) {
                case 1 -> book.createBook();
                case 2 -> library.addBookLibrary();
                case 3 -> library.deleteBookLibrary();
                case 4 -> library.findbyName();
                case 5 -> library.findAllBook();
                case 6 -> library.rentBook();
                case 7 -> library.returnBook();
                default -> {
                    System.out.println("입력 값이 올바르지 않습니다. \n 되돌아갑니다.");
                }
            }
        }

    }


}
