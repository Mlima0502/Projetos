package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Order.BubbleSort;
import Order.InsertionSort;
import Order.Ordenacao;
import Order.QuickSort;
import Search.Busca;
import Search.BuscaBinaria;
import Search.Sequencial;

import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPath;
	private JLabel lTipoOrdenacao;
	private JButton btnOrdenar;
	
	private static JTable table;
	public static JProgressBar progressBar;
	private static JComboBox<String> comboTipoOrdenacao;
	private static JComboBox<String> comboTipoBusca;
	private static JLabel lQtd;
	private static JTextField txtIndex;
	private static JTextField txtElement;

	private static List<Long> lista = new LinkedList<Long>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lPath = new JLabel("Path");
		lPath.setBounds(10, 11, 87, 14);
		contentPane.add(lPath);

		txtPath = new JTextField();
		txtPath.setEditable(false);
		txtPath.setBounds(115, 8, 380, 20);
		contentPane.add(txtPath);
		txtPath.setColumns(10);

		JButton btnSelecionarArquivo = new JButton("Buscar");
		btnSelecionarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPath.setText(GetPath());
				if (!txtPath.getText().isBlank()) {
					lista = Utilitarios.FileUtils.CarregarArquivoNumeros(txtPath.getText());
					new Thread(Listar).start();
				}	
			}
		});
		btnSelecionarArquivo.setBounds(495, 7, 79, 21);
		contentPane.add(btnSelecionarArquivo);

		lTipoOrdenacao = new JLabel("Tipo de ordena\u00E7\u00E3o");
		lTipoOrdenacao.setBounds(10, 36, 110, 14);
		contentPane.add(lTipoOrdenacao);

		comboTipoOrdenacao = new JComboBox<String>();
		comboTipoOrdenacao.setBounds(115, 32, 459, 22);
		comboTipoOrdenacao.addItem("Quick Sort");
		comboTipoOrdenacao.addItem("Bubble Sort");
		comboTipoOrdenacao.addItem("Insertion Sort");
		contentPane.add(comboTipoOrdenacao);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setBounds(10, 61, 564, 23);
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.size() > 0) {
					new Thread(Ordenar).start();
				} else {
					JOptionPane.showMessageDialog(null, "Lista de dados Vazia.", "", 1);
				}
			}
		});
		contentPane.add(btnOrdenar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 95, 564, 187);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 564, 187);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(getNewModel());
		scrollPane.setViewportView(table);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 83, 564, 7);
		contentPane.add(progressBar);

		JLabel lQtdNumeros = new JLabel("Quantidade de Registros:");
		lQtdNumeros.setBounds(345, 293, 150, 14);
		contentPane.add(lQtdNumeros);

		lQtd = new JLabel("0");
		lQtd.setHorizontalAlignment(SwingConstants.RIGHT);
		lQtd.setBounds(495, 293, 79, 14);
		contentPane.add(lQtd);
		
		comboTipoBusca = new JComboBox<String>();
		comboTipoBusca.addItem("Binária");
		comboTipoBusca.addItem("Sequencial");
		comboTipoBusca.setBounds(115, 318, 459, 22);
		contentPane.add(comboTipoBusca);
		
		JLabel lTipoBusca = new JLabel("Tipo de busca");
		lTipoBusca.setBounds(10, 322, 110, 14);
		contentPane.add(lTipoBusca);
		
		txtElement = new JTextField();
		txtElement.setBounds(115, 347, 116, 20);
		contentPane.add(txtElement);
		txtElement.setColumns(10);
		
		JLabel lElemento = new JLabel("Elemento");
		lElemento.setBounds(10, 350, 110, 14);
		contentPane.add(lElemento);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(246, 346, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.size() > 0) {
					new Thread(Buscar).start();
				} else {
					JOptionPane.showMessageDialog(null, "Lista de dados Vazia.", "", 1);
				}
			}
		});
		contentPane.add(btnBuscar);
		
		JLabel lIndex = new JLabel("Index");
		lIndex.setBounds(354, 351, 101, 14);
		contentPane.add(lIndex);
		
		txtIndex = new JTextField();
		txtIndex.setEditable(false);
		txtIndex.setColumns(10);
		txtIndex.setBounds(458, 347, 116, 20);
		contentPane.add(txtIndex);
	}

	private static DefaultTableModel getNewModel() {
		return new DefaultTableModel(new Object[][] {}, new String[] { "N\u00FAmeros" });
	}

	private String GetPath() {
		JFileChooser fileChooserDialog = new JFileChooser();
		File selectedFile;

		int i = fileChooserDialog.showOpenDialog(new JFrame());

		if (i == JFileChooser.APPROVE_OPTION) {
			if (fileChooserDialog.getSelectedFile() != null) {
				selectedFile = fileChooserDialog.getSelectedFile();
				return selectedFile.getAbsolutePath();
			}
		}

		return "";
	}

	private static Runnable Ordenar = new Runnable() {

		@Override
		public void run() {
			JOptionPane.showMessageDialog(null, "Ordenação Iniciada.", "Aviso", 1);

			Ordenacao ordenacao;
			switch (comboTipoOrdenacao.getSelectedItem().toString()) {
			case "Bubble Sort":
				ordenacao = new BubbleSort(lista);
				break;
			case "Quick Sort":
				ordenacao = new QuickSort(lista);
				break;
			case "Insertion Sort":
				ordenacao = new InsertionSort(lista);
				break;
			default:
				ordenacao = new Ordenacao(lista);
			}
			ordenacao.OrdenarCrescente();
			lista = ordenacao.getListaOrdenada();
			new Thread(Listar).start();
		}
	};

	private static Runnable Listar = new Runnable() {

		@Override
		public void run() {
			table.setModel(getNewModel());
			for (Long num : lista) {
				((DefaultTableModel) table.getModel()).addRow(new Long[] { num });
				table.validate();
			}
			lQtd.setText(String.valueOf(lista.size()));
		}
	};
	
	private static Runnable Buscar = new Runnable() {

		@Override
		public void run() {
			
			if (txtElement.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo \"Elemento\" está vazio.", "Alerta", 1);
				return;
			}
			
			Busca busca;
			switch (comboTipoBusca.getSelectedItem().toString()) {
			case "Binária":
				busca = new BuscaBinaria(lista);
				break;
			case "Sequencial":
				busca = new Sequencial(lista);
				break;
			default:
				busca = new Busca(lista);
			}
			
			try
			{
				Long element = Long.parseLong(txtElement.getText());
				txtIndex.setText(String.valueOf(busca.getIndexElement(element)));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Insira apenas números no campo \"Elemento\".", "Alerta", 1);
			}
		}
	};
}
