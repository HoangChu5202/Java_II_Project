package final_project.data_access;

import final_project.MyException;
import java1refresher.Book;
import java1refresher.Person;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class BookDAO_MySQL implements MyDAO<Book> {

    List<Book> list;
    int nextId = 0;
    private Connection getConnection() throws SQLException {
        String driver = "mariadb";
        String host = "localhost";
        String port = "3307";
        String db_name = "java2";
        String userName = "root";
        String password = "";
        String connectionString = "jdbc:" + driver + "://" + host + ":" + port + "/" + db_name;
        Connection connection = DriverManager.getConnection(connectionString, userName, password);
        return connection;
    }

    @Override
    public void readInData() throws MyException {
        try(Connection connection = getConnection()) {
            if(connection.isValid(2)){
                System.out.println("Connection successful");
                CallableStatement statement = connection.prepareCall("{call sp_get_all_book()}");
                ResultSet resultSet = statement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()){
                    Book book = new Book();
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    Person author = new Person();
                    author.setFirstNameAndLastName(resultSet.getString("author"));
                    book.setAuthor(author);
                    book.setRead(resultSet.getBoolean("read"));
                    book.setNumPages(resultSet.getInt("numPages"));
                    book.setDatePublished(resultSet.getDate("datePublished").toLocalDate());
                    book.setUnitPrice(resultSet.getDouble("unitPrice"));
                    nextId = book.getId() + 1;
                    list.add(book);
                }
                resultSet.close();
                statement.close();
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void add(Book obj) throws MyException {
        // add to ArrayList
        if( list== null){
            readInData();
        }
        list.add(obj);
        // add to database
        try (Connection connection = getConnection()){
            CallableStatement statement = connection.prepareCall("{call sp_add_book(?, ?, ?, ?, ?, ?, ?)}");
            statement.setInt(1, nextId++);
            statement.setString(2, obj.getTitle());
            statement.setString(3, obj.getAuthor().getFullName());
            statement.setBoolean(4, obj.isRead());
            statement.setInt(5, obj.getNumPages());
            statement.setDate(6, Date.valueOf(obj.getDatePublished()));
            statement.setDouble(7, obj.getUnitPrice());
            if(statement.execute() == false){
                System.out.println("Book added");
            } else {
                System.out.println("Book not added");
            }
            statement.close();
        } catch (SQLException ex){

        }
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
        if (list==null){
            readInData();
        }
        return list;
    }

    @Override
    public void set(int id, Book obj) throws MyException {

    }

    @Override
    public boolean remove(Book obj) throws MyException {
        return false;
    }
}
