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
		JOptionPane.showMessageDialog(null, "Método de Ordenação não definido.");
	}
	
	protected  void msgFim(long tempoExecucao) {
		JOptionPane.showMessageDialog(null, "Ordenação Finalizada.\nTempo de Execução: " + tempoExecucao + "ms", "Aviso", 1);	
	}
}
