package Order;
import java.util.Date;
import java.util.List;

import Main.Frame;

public class BubbleSort extends Ordenacao{

	public BubbleSort(List<Long> lista) {
		super(lista);
	}
	
	public void OrdenarCrescente() {
		Frame.progressBar.setMinimum(0);
		Frame.progressBar.setMaximum(lista.size());
		Frame.progressBar.setValue(0);
		Date dtInicio = new Date();
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size() - 1; j++) {
				if (lista.get(j) > lista.get(j + 1)) {
					lista.add(j+1, lista.remove(j));
				}
			}
			Frame.progressBar.setValue(i+1);
		}
		Date dtFim = new Date();
		long tempoExecucao = dtFim.getTime() - dtInicio.getTime();
		msgFim(tempoExecucao);
	}
}
