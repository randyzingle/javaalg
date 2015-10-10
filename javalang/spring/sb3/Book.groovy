class Book {
  String author
  String title
}

class BookTests {
  @Test 
  void testBooks() {
    Book book = new Book(author: "JRR Tolkein", title: "The Hobbit")
    assertEquals("JRR Tolkein", book.author)
    assertEquals("Hobbit", book.title)
  }
}