package teste.app.repositories;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import teste.domain.MovimentoBancario;
import teste.domain.repo.IMovimentosBancariosRepository;

public class MovimentoBancarioRepository extends BaseDaoImpl<MovimentoBancario, Integer> 
implements IMovimentosBancariosRepository {

	
	public MovimentoBancarioRepository(ConnectionSource conn) throws SQLException{
		super(MovimentoBancario.class);		
		setConnectionSource(conn);
		initialize();
	}
	
	
	@Override
	public List<MovimentoBancario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimentoBancario FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreateOrUpdate(MovimentoBancario entidade) throws SQLException {
		create(entidade);
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
