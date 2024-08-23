import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();
    Book book = new Book();

    //생성자 : 책 목록 초기화 필요
    public Library() {
        bookList = new ArrayList<>();
    }

    //메서드 : 도서관에 책 추가.
    public void addBookLibrary() {

        //입력 값을 받아서 도서관 클래스에 저장
        System.out.println("어떤 책을 도서관에 추가하시겠습니까?");
        for(int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i).toString());
        }
        String bookNameLibrary = scanner.nextLine();
        if(bookList.equals(bookNameLibrary)) {
            bookList.add(book);
        } else {
            System.out.println(bookNameLibrary + " 제목의 책이 존재하지 않습니다.");
        }
    }

    // 책 이름으로 조회,
    public String findbyName(){


        return null;
    }
    // 모든 책 조회,
    public String findAllBook(){
        return null;
    }
    // 도서관에 책 제거,
    public void deleteBookLibrary() {}


    // 책 대여
    public void rentBook(){}

    // 책 반납
    public void returnBook(){}

    public void addBook(Book book) {
    }
}