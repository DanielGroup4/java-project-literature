package com.project.bookcatalog.service;
import com.project.bookcatalog.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class GutendexResponse {
    private List<Book> results;
}
