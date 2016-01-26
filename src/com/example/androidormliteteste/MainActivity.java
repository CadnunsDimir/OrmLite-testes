package com.example.androidormliteteste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.j256.ormlite.support.ConnectionSource;

import teste.app.infra.OrmHelper;
import teste.app.repositories.ContaBancariaRepository;
import teste.app.repositories.MovimentoBancarioRepository;
import teste.domain.ContaBancaria;
import teste.domain.MovimentoBancario;
import teste.domain.repo.IContaBancariaRepository;
import teste.domain.repo.IMovimentosBancariosRepository;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

	OrmHelper ormHelper;
	private IContaBancariaRepository contaBancariaRepository;
	private IMovimentosBancariosRepository movRepository;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
        	ormHelper = new OrmHelper(this);
        	ConnectionSource conn= ormHelper.getConnectionSource();
        	movRepository = new MovimentoBancarioRepository(conn);
			contaBancariaRepository = new ContaBancariaRepository(conn,movRepository);
			ArrayList<ContaBancaria> novasContas = new ArrayList<ContaBancaria>();
			
			ContaBancaria itau = new ContaBancaria();
			itau.setCodigoBanco(341);
			itau.setNome("Itau");
			itau.setSaldo(1000.89);
			itau.setMovimentos(
			  Arrays.asList(
				new MovimentoBancario(
					"21/01/2016",
					-20.56,
					"Saque"
				)));
			ContaBancaria bradesco = new ContaBancaria();
			bradesco.setCodigoBanco(341);
			bradesco.setNome("Bradesco");
			bradesco.setSaldo(7000.89);
			bradesco.setMovimentos(
			  Arrays.asList(
				new MovimentoBancario(
					"21/01/2016",
					20.56,
					"rendimentos"
				)));
			novasContas.add(itau);
			novasContas.add(bradesco);
			contaBancariaRepository.AddRange(novasContas);
			List<ContaBancaria> contasSalvas  = contaBancariaRepository.listar();
			for (ContaBancaria contaBancaria : contasSalvas) {
				Log.i("Contas", "Cod :"+contaBancaria.getNome());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
