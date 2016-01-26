package teste.app.repositories;

import java.sql.SQLException;
import java.util.List;

import teste.domain.ContaBancaria;
import teste.domain.MovimentoBancario;
import teste.domain.repo.IContaBancariaRepository;
import teste.domain.repo.IMovimentosBancariosRepository;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class ContaBancariaRepository extends BaseDaoImpl<ContaBancaria, Integer>
	implements IContaBancariaRepository
{
	
	private IMovimentosBancariosRepository movimentosRepository;

	public ContaBancariaRepository(ConnectionSource conn, IMovimentosBancariosRepository movBancariosRepository) throws SQLException{
		super(ContaBancaria.class);
		setConnectionSource(conn);
		initialize();
		movimentosRepository = movBancariosRepository;
	}


	@Override
	public List<ContaBancaria> listar() throws SQLException {
		// TODO Auto-generated method stub
		return queryForAll();
	}

	@Override
	public ContaBancaria FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreateOrUpdate(ContaBancaria entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void AddRange(List<ContaBancaria> contas) throws SQLException {
		for (ContaBancaria contaBancaria : contas) {
			int result = create(contaBancaria);
			if (result == 1) {
				for (MovimentoBancario moBancario : contaBancaria.getMovimentos()) {
					moBancario.setContaBancaria(contaBancaria);
					movimentosRepository.CreateOrUpdate(moBancario);
				}
			}
		}		
	}

}
