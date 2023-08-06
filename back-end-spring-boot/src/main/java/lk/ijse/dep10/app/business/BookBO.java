package lk.ijse.dep10.app.business;

import lk.ijse.dep10.app.dto.BookDTO;

import java.util.List;

public interface BookBO {

    List<BookDTO> getAllBooks() throws Exception;

    void saveBook(BookDTO bookDTO) throws Exception;
}
