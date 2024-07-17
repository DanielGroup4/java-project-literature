package com.project.bookcatalog.service;

import com.project.bookcatalog.model.Book;
import com.project.bookcatalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books/";

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = GUTENDEX_API_URL + "?search=" + query;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        return response.getResults();
    }
}
