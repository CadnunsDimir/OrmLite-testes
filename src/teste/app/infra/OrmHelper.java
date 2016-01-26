package teste.app.infra;

import teste.domain.ContaBancaria;
import teste.domain.MovimentoBancario;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class OrmHelper extends OrmLiteSqliteOpenHelper {

	private static final String databaseName = "orm.db";
	private static final int databaseVersion = 1;

	public OrmHelper(Context context){
		super(context, databaseName, null, databaseVersion);
	}
	
	@Override
	public void onCreate(SQLiteDatabase bancoDados, ConnectionSource conn){
		try {
			TableUtils.createTable(conn, ContaBancaria.class);
			TableUtils.createTable(conn, MovimentoBancario.class);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void onUpgrade(SQLiteDatabase bancoDados, ConnectionSource conn, int newVersion,
			int arg3) {
		try {
			TableUtils.createTable(conn, ContaBancaria.class);
			TableUtils.createTable(conn, MovimentoBancario.class);
			onCreate(bancoDados, conn);
		} catch (java.sql.SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}
