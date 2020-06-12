package Search;

import java.util.List;

import javax.swing.JOptionPane;

public class Sequencial extends Busca{

	public Sequencial(List<Long> lista) {
		super(lista);
	}

	public int getIndexElement(Long element){	
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(element)) {
				return i;
			}
		}
				
		JOptionPane.showMessageDialog(null, "Elemento não encontrado na lista.");
		return -1;
	}
}
