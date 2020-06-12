package Search;

import java.util.List;

import javax.swing.JOptionPane;

public class Busca {
	
	protected List<Long> lista;
	
	public Busca(List<Long> lista) {
		this.lista = lista;
	}
	
	public int getIndexElement(Long element){	
		JOptionPane.showMessageDialog(null, "Tipo de Busca não definida.");
		return -1;
	}
	
	public long getElementIndex(int index) {
		return this.lista.get(index);
	}
	
	protected  void msgFim(long tempoExecucao) {
		JOptionPane.showMessageDialog(null, "Ordenação Finalizada.\nTempo de Execução: " + tempoExecucao + "ms", "Aviso", 1);	
	}
}
