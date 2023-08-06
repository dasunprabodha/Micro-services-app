package lk.ijse.dep10.app.business.impl;

import lk.ijse.dep10.app.business.BookBO;
import lk.ijse.dep10.app.business.exception.DuplicateRecordException;
import lk.ijse.dep10.app.business.util.Transformer;
import lk.ijse.dep10.app.dao.custom.BookDAO;
import lk.ijse.dep10.app.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookBOImpl implements BookBO {

    private final BookDAO bookDAO;
    private final Transformer transformer;

    public BookBOImpl(BookDAO bookDAO, Transformer transformer) {
        this.bookDAO = bookDAO;
        this.transformer = transformer;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDTO> getAllBooks() throws Exception {
        return bookDAO.findAll().stream().map(transformer::fromBookEntity).collect(Collectors.toList());
    }

    @Override
    public void saveBook(BookDTO bookDTO) throws Exception {
        if (bookDAO.existsById(bookDTO.getIsbn())) {
            throw new DuplicateRecordException(bookDTO.getIsbn() + " already exists");
        }
        bookDAO.save(transformer.toBookEntity(bookDTO));
    }
}
