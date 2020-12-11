package model.dao;

import model.entity.Account;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

public interface Dao<T> {

	boolean createIfNotExists();

	boolean add(T t);

	ArrayList<T> getAll(long id);

	T getByAccountNumber(long accountNumber);

	boolean update(T t);

	boolean remove(long accountNumber);

}
