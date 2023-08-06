package lk.ijse.dep10.app.business.util;

import lk.ijse.dep10.app.dto.BookDTO;
import lk.ijse.dep10.app.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Book toBookEntity(BookDTO bookDTO) {
        return mapper.map(bookDTO, Book.class);
    }

    public BookDTO fromBookEntity(Book bookEntity) {
        return mapper.map(bookEntity, BookDTO.class);
    }
}
