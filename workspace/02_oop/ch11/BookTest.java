package ch11;

class Book {
    String title;
    String author;

    // 생성자 작성
    Book(){
//        this.title = "제목미상";
//        this.author = "작가미상";
        // 생성자 안에서만 사용할 수 있다.
        this("제목미상","작가미상");
    }
    Book(String title, String author){
         this.title = title;
         this.author = author;
    }
}

public class BookTest{
    public static void main(){
        Book book1 = new Book();
        book1.title = "자바 기초";
        book1.author = "자바의 신";
        Book book2 = new Book("자바를 자바라!","용썜");

        System.out.println("제목: " +book1.title + ", 작가: " + book1.author);
        System.out.println("제목: " +book2.title + ", 작가: " + book2.author);
    }
}
