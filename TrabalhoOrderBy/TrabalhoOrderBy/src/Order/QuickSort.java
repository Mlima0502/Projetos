package Order;

import java.util.Date;
import java.util.List;

import Main.Frame;

public class QuickSort extends Ordenacao {

	public QuickSort(List<Long> lista) {
		super(lista);
	}
	
	public void OrdenarCrescente()
	{
		Frame.progressBar.setMinimum(0);
		Frame.progressBar.setMaximum(lista.size());
		Frame.progressBar.setValue(0);
		
		Date dtInicio = new Date();
		
		OrdenarCrescente(0, lista.size());
		
		Date dtFim = new Date();
		long tempoExecucao = dtFim.getTime() - dtInicio.getTime();
		
		msgFim(tempoExecucao);
	}
	
	private void OrdenarCrescente(int inicio, int fim)
	{
		Long pivo, aux;
		int i = inicio;
		int j = fim - 1;
		pivo = lista.get((inicio + fim) / 2);
		while(i <= j)
		{
			while(lista.get(i) < pivo && i < fim)
			{
				i++;
				Frame.progressBar.setValue(Frame.progressBar.getValue()+1);
			}
			while(lista.get(j) > pivo && j > inicio)
			{
				j--;
				Frame.progressBar.setValue(Frame.progressBar.getValue()+1);
			}
			if(i <= j)
			{
				aux = lista.get(i);
				lista.set(i, lista.get(j));
				lista.set(j, aux);
				i++;
				j--;
				Frame.progressBar.setValue(Frame.progressBar.getValue()+1);
			}
		}
		if(j > inicio)
			OrdenarCrescente(inicio, j+1);
		if(i < fim)
			OrdenarCrescente(i, fim);
	}
}
