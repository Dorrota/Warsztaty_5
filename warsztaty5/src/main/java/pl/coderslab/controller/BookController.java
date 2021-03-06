package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService service;

    @Autowired
    public BookController(MemoryBookService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/all-books")
    public List<Book> getAllBooks(){
        return service.getList();
    }

    @RequestMapping("/book/{id}")
    public Book getBook(@PathVariable Long id){
        return service.findOne(id);
    }
}
