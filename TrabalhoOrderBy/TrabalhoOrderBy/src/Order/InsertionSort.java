package Order;

import java.util.Date;
import java.util.List;

import Main.Frame;

public class InsertionSort extends Ordenacao {

	public InsertionSort(List<Long> lista) {
		super(lista);
	}

	public void OrdenarCrescente() {
		
		Frame.progressBar.setMinimum(0);
		Frame.progressBar.setMaximum(lista.size());
		Frame.progressBar.setValue(0);	
		
		Date dtInicio = new Date();
		
		for (int i = 1; i < lista.size(); i++) {

			Long aux = lista.get(i);
			int j = i;

			while ((j > 0) && (lista.get(j - 1) > aux)) {
				lista.set(j, lista.get(j - 1));
				j -= 1;
			}
			lista.set(j, aux);
			Frame.progressBar.setValue(Frame.progressBar.getValue()+1);
		}
		
		Date dtFim = new Date();
		long tempoExecucao = dtFim.getTime() - dtInicio.getTime();
		
		msgFim(tempoExecucao);
	}
}
