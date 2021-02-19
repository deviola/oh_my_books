package com.app.ohmybooks.service;

import com.app.ohmybooks.domain.Book;
import com.app.ohmybooks.domain.Rent;
import com.app.ohmybooks.domain.Title;
import com.app.ohmybooks.domain.User;
import com.app.ohmybooks.exception.NotFoundException;
import com.app.ohmybooks.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class BookService {
    
    private static final String RENTED = "rented";
    private static final String IN_LIBRARY = "in library";
    
    @Autowired
    private BookRepo bookRepo;
    
    @Autowired
    private TitleService titleService;
    
    @Autowired
    private RentService rentService;
    
    @Autowired
    private UserService userService;
    
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    
    public Book saveBook(final Book book) {
        return bookRepo.save(book);
    }
    
    public Optional<Book> getBookById(final Long id) {
        return bookRepo.findById(id);
    }
    
    public Long getAmountOfAvailableBooksTitles(final Long titleId) {
        Title title = titleService.getTitleByid(titleId).orElse(null);

        Long booksQuantity = 0L;

        if(title != null) {
            booksQuantity = IntStream.range(0, title.getBooks().size())
                    .filter(n -> title.getBooks().get(n).getStatus().equalsIgnoreCase(IN_LIBRARY))
                    .count();
        }
        return booksQuantity;
    }

    public Book changeStatus(final Long bookId, final String status) {
        Book book = bookRepo.findById(bookId).orElse(null);
        book.setStatus(status);
        bookRepo.save(book);
        return book;
    }

    public void rentBook(final Long userId, final Long bookId) throws NotFoundException{
        User user = userService.getUserById(userId).orElse(null);
        Book book = bookRepo.findById(bookId).orElse(null);

        if(book.getStatus().equalsIgnoreCase(IN_LIBRARY)) {
            book.setStatus(RENTED);
            Rent rent = new Rent(user, book, LocalDate.now(), LocalDate.now().plusDays(30));
            bookRepo.save(book);
            rentService.saveRent(rent);
        } else {
            throw new NotFoundException();
        }
    }
    
    public void returnBook(final Long userId, final Long bookId, final String status) throws NotFoundException {
        Rent rent = rentService.getSpecificRental(userId, bookId).orElse(null);
        Book book = rent.getBook();
        book.setStatus(status);
        rent.setRentedTo(LocalDate.now());
        bookRepo.save(book);
        rentService.saveRent(rent);
    }
}
