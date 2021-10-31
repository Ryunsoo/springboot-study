package com.kh.bookmanager.view.book;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.kh.bookmanager.book.Book;
import com.kh.bookmanager.book.BookController;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bookController = new BookController();
	Long bkIdx = null;
	
	public void bookMenu() {
		
		do {
			System.out.println("\n*** 도서 관리 ***");
			System.out.println("1. 도서 전체 조회");
			System.out.println("2. 도서 등록");
			System.out.println("3. 도서 소개 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 검색");
			System.out.println("6. 종료");
			System.out.print("번호 선택 : ");
			
			switch(sc.nextInt()) {
			case 1 :
				//bookController의 searchAllBooks()를 호출하고
				//결과값을 출력
				List<Book> bookList = bookController.searchAllBooks();
				for (Book book : bookList) {
					System.out.println(book);
				}
				break;
			case 2 : 
				//registBook 메서드를 호출해 사용자로부터 추가할 도서 정보를 입력받고
				//bookController의 registBook 메서드를 호출해 도서정보를 추가
				//도서가 성공적으로 추가되면 "도서 추가 성공"
				//도서 추가에 실패하면 "도서 추가 실패" 출력
				if(bookController.registBook(registBook()) != 0) {
					System.out.println("도서 등록이 완료되었습니다.");
				}else {
					System.out.println("도서 등록에 실패하였습니다.");
				}
				
				break;
			case 3:
				//수정할 도서의 도서번호와 도서 소개(info컬럼)를 사용자로 부터 입력받아
				//bookController 의 modifyBook을 호출해 도서 소개를 수정하고
				//성공하면 "도서 수정 성공", 실패하면 "도서 수정 실패"를 출력하시오.
				System.out.print("수정할 도서번호 : ");
				bkIdx = sc.nextLong();
				System.out.print("변경할 도서 소개 : ");
				String info = sc.next();
				
				int modRes = bookController.modifyBook(bkIdx, info);
				
				if(modRes > 0) {
					System.out.println("성공적으로 도서 소개가 변경되었습니다.");
				}else if(modRes == 0) {
					System.out.println("입력하신 도서번호가 존재하지 않아 실패하였습니다.");
				}else {
					System.out.println("소개 변경 중 에러가 발생하였습니다.");
				}
				break;
			case 4:
				//삭제할 도서의 도서번호를 사용자로 부터 입력받아
				//bookController 의 deleteBook 메서드를 호출하고
				//도서 삭제에 성공하면 "도서 삭제 성공", 실패하면 "도서 삭제 실패" 출력
				System.out.print("삭제할 도서번호 : ");
				bkIdx = sc.nextLong();
				int delRes = bookController.removeBook(bkIdx);
				if(delRes > 0) {
					System.out.println("성공적으로 도서가 삭제되었습니다.");
				}else if(delRes == 0) {
					System.out.println("입력하신 도서번호가 존재하지 않아 실패하였습니다.");
				}else {
					System.out.println("도서 삭제 중 에러가 발생하였습니다.");
				}
				break;
			//searchBookMenu 메서드를 호출해 도서 검색 메뉴창 출력
			case 5: searchBookMenu(); break;		
			case 6: return;
			default : System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}while(true);
	}
	
	public void searchBookMenu() {
		List<Book> bookList = null;
		do {
			System.out.println("\n*** 도서 검색 메뉴 ***");
			System.out.println("1. 도서 키워드 검색");
			System.out.println("2. 인기 top 5 검색");
			System.out.println("3. 이전 메뉴로 이동");
			System.out.print("입력 : ");
			
			switch(sc.nextInt()) {
			case 1 :
				//bookController의 searchBookByTitle 메서드에 사용자가 입력한
				//도서명을 전달하고 결과를 출력하시오.	
				System.out.print("검색할 키워드를 입력하세요 : ");
				bookList = bookController.searchBookByTitle(sc.next());
				if(bookList.isEmpty()) {
					System.out.println("입력하신 키워드가 포함된 도서가 없습니다.");
					break;
				}
				for (Book book : bookList) {
					System.out.println(book);
				}
				break;
			case 2 :
				System.out.println("대출 건수가 많은 상위 5권의 목록입니다.");
				bookList = bookController.searchBookWithRank();
				for (int i = 0; i < 5; i++) {
					System.out.println(bookList.get(i));
				}
				break;
			case 3: return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
			}
			
		}while(true);
	}
	
	public Book registBook() {
		Book book = new Book();
		System.out.println("도서정보를 입력하세요---------------------");
		System.out.print("도서 제목 : ");
		book.setTitle(sc.next());
		
		System.out.print("작가 : " );
		book.setAuthor(sc.next());
		
		System.out.print("ISBN : ");
		book.setIsbn(sc.next());
		
		System.out.print("카테고리코드 : ");
		book.setCategory(sc.next());
		return book;
	}
	
	
	
	

}
