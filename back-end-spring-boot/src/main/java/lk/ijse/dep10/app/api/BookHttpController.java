package lk.ijse.dep10.app.api;

import lk.ijse.dep10.app.business.BookBO;
import lk.ijse.dep10.app.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/books")
public class BookHttpController {
    private final BookBO bookBO;

    public BookHttpController(BookBO bookBO) {
        this.bookBO = bookBO;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() throws Exception {
        return bookBO.getAllBooks();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody @Valid BookDTO bookDTO) throws Exception {
        bookBO.saveBook(bookDTO);
    }
    
}
