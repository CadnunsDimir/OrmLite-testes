package teste.domain.repo;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
	List<T> listar() throws SQLException;
	T FindById(int id);
	void CreateOrUpdate(T entidade) throws SQLException;
	void Delete(int id);
}
