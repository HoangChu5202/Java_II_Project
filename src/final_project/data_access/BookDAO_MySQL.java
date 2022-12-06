package final_project.data_access;

import final_project.MyException;
import java1refresher.Book;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class BookDAO_MySQL implements MyDAO<Book> {

    @Override
    public void readInData() throws MyException {

    }

    @Override
    public void add(Book obj) throws MyException {

    }

    @Override
    public Book get(int id) throws MyException {
        return null;
    }

    @Override
    public List<Book> get(String str) throws MyException {
        return null;
    }

    @Override
    public List<Book> get(LocalDate date) throws MyException {
        return null;
    }

    @Override
    public List<Book> getAll() throws MyException {
        return null;
    }

    @Override
    public void set(int id, Book obj) throws MyException {

    }

    @Override
    public boolean remove(Book obj) throws MyException {
        return false;
    }
}
