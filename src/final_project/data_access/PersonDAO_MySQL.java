package final_project.data_access;

import final_project.MyException;
import java1refresher.Person;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO_MySQL implements MyDAO<Person> {

    List<Person> list;

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
                CallableStatement statement = connection.prepareCall("{call sp_get_all_people()}");
                ResultSet resultSet = statement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    int heightInInches = resultSet.getInt("heightInInches");
                    double weightInPounds = resultSet.getDouble("weightInPounds");
                    LocalDateTime dateOfBirth = resultSet.getTimestamp("dateOfBirth").toLocalDateTime();
                    Person person = new Person(id, firstName, lastName, heightInInches, weightInPounds, dateOfBirth);
                    list.add(person);
                }
                resultSet.close();
                statement.close();
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }


    @Override
    public void add(Person obj) throws MyException {
        // add to ArrayList
        if( list== null){
            readInData();
        }
        list.add(obj);
        // add to database
        try (Connection connection = getConnection()){
            CallableStatement statement = connection.prepareCall("{call sp_add_person(?, ?, ?, ?, ?)}");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setInt(3, obj.getHeightInInches());
            statement.setDouble(4, obj.getWeightInPounds());
            statement.setTimestamp(5, Timestamp.valueOf(obj.getDateOfBirth()));
            if(statement.execute() == false){
                System.out.println("Person added");
            } else {
                System.out.println("Person not added");
            }
            statement.close();
        } catch (SQLException ex){

        }
    }

    @Override
    public Person get(int id) throws MyException {
        Person person = new Person();

        try (Connection connection = getConnection()){
            CallableStatement statement = connection.prepareCall("{call sp_get_person_by_id(?)}");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            person.setId(id);
            if (resultSet.next()){
                person.setFirstName(resultSet.getString("firstName"));
                person.setLastName(resultSet.getString("lastName"));
                person.setHeightInInches(resultSet.getInt("heightInInches"));
                person.setWeightInPounds(resultSet.getDouble("weightInPounds"));
                person.setDateOfBirth(resultSet.getTimestamp("dateOfBirth").toLocalDateTime());
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex){

        }

        return person;
    }

    @Override
    public List<Person> get(String str) throws MyException {
        List<Person> people = new ArrayList<>();

        try (Connection connection = getConnection()){
            CallableStatement statement = connection.prepareCall("{call sp_get_person_by_name(?)}");
            statement.setString(1, str);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("firstName"));
                person.setLastName(resultSet.getString("lastName"));
                person.setHeightInInches(resultSet.getInt("heightInInches"));
                person.setWeightInPounds(resultSet.getDouble("weightInPounds"));
                person.setDateOfBirth(resultSet.getTimestamp("dateOfBirth").toLocalDateTime());
                people.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex){

        }

        return people;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        List<Person> people = new ArrayList<>();

        try (Connection connection = getConnection()){
            CallableStatement statement = connection.prepareCall("{call sp_get_person_by_name(?)}");
            statement.setTimestamp(1, Timestamp.valueOf(date.atStartOfDay()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("firstName"));
                person.setLastName(resultSet.getString("lastName"));
                person.setHeightInInches(resultSet.getInt("heightInInches"));
                person.setWeightInPounds(resultSet.getDouble("weightInPounds"));
                person.setDateOfBirth(resultSet.getTimestamp("dateOfBirth").toLocalDateTime());
                people.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex){

        }

        return people;
    }

    @Override
    public List<Person> getAll() throws MyException {
        if (list == null){
            readInData();
        }
        return list;
    }

    @Override
    public void set(int id, Person obj) throws MyException {
        // update database
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_update_person(?,?,?,?,?,?)}");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getFirstName());
            statement.setString(3, obj.getLastName());
            statement.setInt(4, obj.getHeightInInches());
            statement.setDouble(5, obj.getWeightInPounds());
            statement.setTimestamp(6, Timestamp.valueOf(obj.getDateOfBirth()));
            statement.execute();
            statement.close();

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        // update Arraylist
        list.set(id,obj);
    }

    @Override
    public boolean remove(Person obj) throws MyException {
        // update database
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_delete_person(?)}");
            statement.setInt(1, obj.getId());
            statement.execute();
            statement.close();
            //update ArrayList
            list.remove(obj);
            return true;
        } catch(SQLException e) {

        }
        return false;
    }
}
