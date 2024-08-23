
public class LibraryContext {
    private static LibraryContext instance;

    private LibraryContext() {
        // 초기화 작업
    }

    public static LibraryContext getInstance() {
        if (instance == null) {
            instance = new LibraryContext();
        }
        return instance;
    }
}

// 기타 필요한