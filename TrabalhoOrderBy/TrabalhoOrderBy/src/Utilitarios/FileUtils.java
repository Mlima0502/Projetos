package Utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileUtils {

	public static List<Long> CarregarArquivoNumeros(String Path) {
		
		List<Long> lista = new LinkedList<Long>();
		if (Path == null || Path.equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado!", "Erro", 0);
			return lista;
		}
				
		try {

			File myObj = new File(Path);
			Scanner myReader = new Scanner(myObj);			
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				lista.add(Long.parseLong(data));
			}
			myReader.close();
			JOptionPane.showMessageDialog(null, "Arquivo Lido com sucesso!");
		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu o seguinte erro:");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Ocorreu o seguinte erro:");
			e.printStackTrace();
		}
			
		return lista;
	}
}
