package Search;

import java.util.List;

import javax.swing.JOptionPane;

public class BuscaBinaria extends Busca{

	public BuscaBinaria(List<Long> lista) {
		super(lista);
	}
	
	public int getIndexElement(Long element){	
		
		int inicio = 0;
        int fim = lista.size() - 1;
        int meio;
 
        while(inicio <= fim)
        {
            meio=(inicio + fim) / 2;
 
            if(lista.get(meio).compareTo(element) < 0) {
            	inicio = meio + 1;
            }
            else if(lista.get(meio).compareTo(element) > 0) {
            	fim = meio - 1;
            }
            else {
            	return meio;
            }   
        }
				
		JOptionPane.showMessageDialog(null, "Elemento não encontrado na lista.");
		return -1;
	}
}
