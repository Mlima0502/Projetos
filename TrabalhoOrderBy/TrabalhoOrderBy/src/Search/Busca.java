package Search;

import java.util.List;

import javax.swing.JOptionPane;

public class Busca {
	
	protected List<Long> lista;
	
	public Busca(List<Long> lista) {
		this.lista = lista;
	}
	
	public int getIndexElement(Long element){	
		JOptionPane.showMessageDialog(null, "Tipo de Busca n�o definida.");
		return -1;
	}
	
	public long getElementIndex(int index) {
		return this.lista.get(index);
	}
	
	protected  void msgFim(long tempoExecucao) {
		JOptionPane.showMessageDialog(null, "Ordena��o Finalizada.\nTempo de Execu��o: " + tempoExecucao + "ms", "Aviso", 1);	
	}
}
