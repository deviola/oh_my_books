package com.app.ohmybooks.service;

import com.app.ohmybooks.constant.MessageConstant;
import com.app.ohmybooks.domain.dto.BookDto;
import com.app.ohmybooks.domain.dto.CreateBookReqDto;
import com.app.ohmybooks.entity.*;
import com.app.ohmybooks.exception.NotFoundException;
import com.app.ohmybooks.repository.Author2BookRepository;
import com.app.ohmybooks.repository.AuthorRepository;
import com.app.ohmybooks.repository.BookRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookService {
    
    private static final String RENTED = "rented";
    private static final String IN_LIBRARY = "in library";

    private final BookRepository bookRepository;
    private final UserService userService;
    private final AuthorRepository authorRepository;
    private final Author2BookRepository author2BookRepository;

    @Autowired
    public BookService(BookRepository bookRepository,
                       UserService userService,
                       AuthorRepository authorRepository,
                       Author2BookRepository author2BookRepository) {
        this.bookRepository = bookRepository;
        this.userService = userService;
        this.authorRepository = authorRepository;
        this.author2BookRepository = author2BookRepository;
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(BookDto::new)
                .collect(Collectors.toList());
    }
    
    public Book createBook(CreateBookReqDto createBookReqDto) {

        Author author = new Author(createBookReqDto.getAuthorName(), createBookReqDto.getAuthorLastName());

        if (authorRepository.findByName(createBookReqDto.getAuthorName(), createBookReqDto.getAuthorLastName()) == null) {
            authorRepository.save(author);
        }

        Book book = Book.builder()
                .title(createBookReqDto.getTitle())
                .author(author) // TODO add multiple authors
                .isbn(createBookReqDto.getIsbn())
                .publicationYear(createBookReqDto.getYear())
                .status(Book.BookStatus.AVAILABLE)
                .build();

        return bookRepository.save(book);
    }
    
    public Optional<Book> getBookById(final Long id) {
        return bookRepository.findById(id);
    }
    
//    public Long getAmountOfAvailableBooksTitles(final Long titleId) {
//        Title title = titleService.getTitleByid(titleId).orElse(null);
//
//        Long booksQuantity = 0L;
//
//        if(title != null) {
//            booksQuantity = IntStream.range(0, title.getBooks().size())
//                    .filter(n -> title.getBooks().get(n).getStatus().equalsIgnoreCase(IN_LIBRARY))
//                    .count();
//        }
//        return booksQuantity;
//    }
//
//    public Book changeStatus(final Long bookId, final String status) {
//        Book book = bookRepository.findById(bookId).orElse(null);
//        book.setStatus(status);
//        bookRepository.save(book);
//        return book;
//    }
//
//    //TODO DO RENTA
//    public void rentBook(final Long userId, final Long bookId) throws NotFoundException{
//        User user = userService.getUserById(userId).orElse(null);
//        Book book = bookRepository.findById(bookId).orElse(null);
//
//        if(book.getStatus().equalsIgnoreCase(IN_LIBRARY)) {
//            book.setStatus(RENTED);
//            Rent rent = new Rent(user, book, LocalDate.now(), LocalDate.now().plusDays(30));
//            bookRepository.save(book);
//            rentService.saveRent(rent);
//        } else {
//            throw new NotFoundException();
//        }
//    }
//
//    //TODO DO RENTA
//    public void returnBook(final Long userId, final Long bookId, final String status) throws NotFoundException {
//        Rent rent = rentService.getSpecificRental(userId, bookId).orElse(null);
//        Book book = rent.getBook();
//        book.setStatus(status);
//        rent.setRentedTo(LocalDate.now());
//        bookRepository.save(book);
//        rentService.saveRent(rent);
//    }
}
