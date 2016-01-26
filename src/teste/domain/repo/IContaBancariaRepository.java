package teste.domain.repo;

import java.sql.SQLException;
import java.util.List;

import teste.domain.ContaBancaria;

public interface IContaBancariaRepository extends IRepository<ContaBancaria>{
	void AddRange(List<ContaBancaria> contas) throws SQLException;
}
