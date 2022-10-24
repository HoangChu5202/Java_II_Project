package final_project;

public interface MyDAO<T> {
    // Read in data. If the data cannot be found, the method will throw an Exception.
    void readInData() throws MyException;
    // Verify that the data has been read in and assigned to a Collection.
    void verifyData();
    // CREATE a new record based on the values in the supplied object.
    void add(T obj);
    // READ a record associated with the id or null if there is no such record.
    // If the record cannot be found, the method will throw an Exception.
    T get(int id) throws MyException;
    // UPDATE a record with the specified id with the specified object.
    // If the record cannot be found, the method will throw an Exception.
    void set(int id, T obj) throws MyException;
    // DELETE a record with the specified id deletes the supplied record
    // If the list does not contain the element, it is unchanged.
    T remove(int id) throws MyException;
    // DELETE a record with the referenced object
    // If the list does not contain the object, it is unchanged.
    T remove(T obj) throws MyException;
}
