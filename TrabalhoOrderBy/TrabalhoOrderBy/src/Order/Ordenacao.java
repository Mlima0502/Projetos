package Order;

import java.util.List;

import javax.swing.JOptionPane;

public class Ordenacao {

	protected List<Long> lista;
	
	public Ordenacao(List<Long> lista) {
		this.lista = lista;
	}
	
	public List<Long> getListaOrdenada(){
		return lista;
	}
	
	public void OrdenarCrescente() {
		JOptionPane.showMessageDialog(null, "M�todo de Ordena��o n�o definido.");
	}
	
	protected  void msgFim(long tempoExecucao) {
		JOptionPane.showMessageDialog(null, "Ordena��o Finalizada.\nTempo de Execu��o: " + tempoExecucao + "ms", "Aviso", 1);	
	}
}
