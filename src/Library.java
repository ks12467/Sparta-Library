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

        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {  // 제목이 동일한 책이 이미 존재하는지 확인
                System.out.println("같은 제목의 책이 이미 등록되어 있습니다. 책 등록을 취소합니다.");
                return "등록 실패: 중복된 책입니다";
            }
        }

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
        boolean alreadyBook = false;
        for (Book book : bookList) {
            if (book.getTitle().equals(bookName)) {
                find = true;

                for (Book libraryBook : libraryList) {
                    if (libraryBook.getTitle().equals(bookName)) {
                        alreadyBook = true;
                        break;
                    }
                }
                if(!alreadyBook) {
                    libraryList.add(book);
                    System.out.println(book.getTitle() + " 제목의 책이 도서관에 추가되었습니다.");
                } else {
                    System.out.println(book.getTitle() + " 제목의 책은 이미 도서관에 등록되어 있습니다.");
                }
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
                for (Book book : libraryList) {
                    System.out.println("[" + book.bookInfo() + "]");
                }
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
        System.out.println("도서관에 등록되어 있는 책을 삭제하시겠습니까?(y/n)");
        String str = scanner.nextLine();
        if (str.equals("y")) {
            if (!libraryList.isEmpty()) {
                System.out.println("도서관에 등록되어 있는 책 목록입니다.");
                for (Book book : libraryList) {
                    System.out.println("[제목 : " + book.getTitle() + "]");
                }
                System.out.println("삭제할 책 제목을 입력해주세요");
                String bookName = scanner.nextLine();

                boolean remove = false;
                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    if (bookName.equals(book.getTitle())) {
                        libraryList.remove(i);
                        System.out.println("책이 삭제되었습니다.");
                        remove = true;
                        break;
                    }
                }
                if (!remove) {
                    System.out.println("책 제목이 일치하지 않습니다.");
                }
            } else {
                System.out.println("도서관에 등록되어 있는 책이 없습니다.");
            }

        } else if (str.equals("n")) {
            System.out.println("삭제를 취소합니다.");
            System.out.println("메인 화면으로 이동합니다.");
        } else {
            System.out.println("입력 값이 올바르지 않습니다.");
            System.out.println("메인 화면으로 이동합니다.");
        }
    }

    // 책 대여
    public void rentBook() {
        boolean borrowListEmpty = false;

        System.out.println("대여 가능한 책 목록입니다.");
        for (Book book : libraryList) {
            if (book.isAvailable() == true) {
                System.out.println("[ 제목 : " + book.getTitle() + "]");
                borrowListEmpty = true;
            }
        }

        if(!borrowListEmpty){
            System.out.println("대여 가능한 책이 없습니다.");
            return;
        }
        System.out.println("대여하시겠습니까?(y/n)");
        String str = scanner.nextLine();
        if (str.equals("y")) {
            System.out.println("대여하실 책 제목을 입력해주세요");
            String bookName = scanner.nextLine();

            boolean find = false;
            for (Book book : libraryList) {
                if (bookName.equals(book.getTitle())) {
                    find = true;
                    if (book.isAvailable()) {
                        book.setAvailable(false);
                        System.out.println("[" + bookName + " 제목의 책이 대여되었습니다.]");
                    } else {
                        System.out.println("[" + bookName + " 제목의 책은 이미 대여 중입니다.]");
                    }
                    break;
                }
            }
            if (!find) {
                System.out.println("책 제목이 일치하지 않습니다.");
            }
        } else {
            System.out.println("대여를 취소합니다.");
        }
    }

    // 책 반납
    public void returnBook() {
        boolean borrowListEmpty = false;

        System.out.println("반납 가능한 책 목록입니다.");
        for (Book book : libraryList) {
            if (book.isAvailable() == false) {
                System.out.println("[ 제목 : " + book.getTitle() + "]");
                borrowListEmpty = true;
            }
        }
        if(!borrowListEmpty){
            System.out.println("반납 가능한 책이 없습니다.");
            return;
        }
        System.out.println("대여하신 책을 반납하겠습니까?(y/n)");
        String str = scanner.nextLine();
        if (str.equals("y")) {
            System.out.println("반납하실 책 제목을 입력해주세요");
            String bookName = scanner.nextLine();

            boolean find = false;
            for (Book book : libraryList) {
                if (bookName.equals(book.getTitle())) {
                    find = true;
                    if (!book.isAvailable()) {
                        book.setAvailable(true);
                        System.out.println("[" + bookName + " 제목의 책이 반납되었습니다.]");
                    } else {
                        System.out.println("[" + bookName + " 제목의 책은 이미 반납되었습니다.]");
                    }
                    break;
                }
            }
            if (!find) {
                System.out.println("책 제목이 일치하지 않습니다.");
            }
        } else {
            System.out.println("반납를 취소합니다.");
        }
    }

}


