package fronteira;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AcervoController;
import entidade.Acervo;
import entidade.Exposicao;

import javax.swing.DefaultComboBoxModel;

public class FormAcervo extends JFrame  {

	private JPanel contentPane;
	private JTextField txtNomeObra;
	private JTextField txtAutor;
	private JTextField txtEntrada;
	private JTextField txtId;
	private JComboBox cmbTipo;
	private JComboBox cmbStatus;
	private JComboBox cmbCategoria;
	private JComboBox cmbItem;
	private JButton   btnAdicionar;
	private JButton  btnDeletar;
	private JButton  btnPesquisar;
	private JButton  btnAlterar;
	SimpleDateFormat sdf = new SimpleDateFormat();
	AcervoController controle = new AcervoController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAcervo frame = new FormAcervo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormAcervo() {
		setTitle("Acervo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome da Obra");
		label.setBounds(10, 34, 90, 14);
		contentPane.add(label);
		
		txtNomeObra = new JTextField();
		txtNomeObra.setColumns(10);
		txtNomeObra.setBounds(10, 57, 191, 20);
		contentPane.add(txtNomeObra);
		
		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(10, 136, 204, 20);
		contentPane.add(txtAutor);
		
		JLabel label_1 = new JLabel("Autor");
		label_1.setBounds(10, 111, 90, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Tipo de Obra");
		label_2.setBounds(10, 179, 72, 14);
		contentPane.add(label_2);
		
		final JComboBox cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Pinturas", "Esculturas", "Gravuras", "Desenhos", "Fotografia", "Arqueologia"}));
		cmbTipo.setBounds(10, 200, 159, 20);
		contentPane.add(cmbTipo);
		
		JLabel label_3 = new JLabel("Categoria");
		label_3.setBounds(10, 231, 72, 14);
		contentPane.add(label_3);
		
		JComboBox cmbCategoria = new JComboBox();
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"", "Arte brasileira", "Arte francesa", "Arte italiana", "Arte das am\u00E9ricas", "Arte da Europa Central", "Arte da Europa Oriental"}));
		cmbCategoria.setBounds(10, 256, 159, 20);
		contentPane.add(cmbCategoria);
		
		JLabel label_4 = new JLabel("Item em exposi\u00E7\u00E3o");
		label_4.setBounds(10, 290, 138, 14);
		contentPane.add(label_4);
		
		JComboBox cmbItem = new JComboBox();
		cmbItem.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cmbItem.setBounds(10, 315, 90, 20);
		contentPane.add(cmbItem);
		
		JLabel label_5 = new JLabel("Data de entrada no museu");
		label_5.setBounds(10, 356, 176, 14);
		contentPane.add(label_5);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(14, 381, 86, 20);
		contentPane.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JLabel label_6 = new JLabel("Descri\u00E7\u00E3o");
		label_6.setBounds(237, 34, 118, 14);
		contentPane.add(label_6);
		
		JTextArea txaDescricao = new JTextArea();
		txaDescricao.setWrapStyleWord(true);
		txaDescricao.setLineWrap(true);
		txaDescricao.setBounds(237, 55, 243, 76);
		contentPane.add(txaDescricao);
		
		JLabel label_7 = new JLabel("Status");
		label_7.setBounds(237, 166, 46, 14);
		contentPane.add(label_7);
		
		JComboBox cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"", "Emprestada", "Vendida", "Em exposi\u00E7\u00E3o", "Doada", "Transferida"}));
		cmbStatus.setBounds(237, 199, 119, 23);
		contentPane.add(cmbStatus);
		
		JButton btnAdicionar = new JButton("Adicionar");
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 controle.adicionar(formToAcervo());
				System.out.println("Teste evento" + "\n" + txtNomeObra.getText()
						+ "\n" + txtId.getText() + "\n"
						+ cmbTipo.getSelectedItem());
				
			}
		});
		
		btnAdicionar.setBounds(230, 255, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Acervo> lista = controle.pesquisar( txtNomeObra.getText() );
				if (lista.size() > 0) {
					AcervoToForm(lista.get(0));
				}
				}
		});
		btnPesquisar.setBounds(230, 286, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 controle.alterar(formToAcervo());
				 System.out.println("Alterado com sucesso");				
			}
		});
		
		btnAlterar.setBounds(230, 314, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 controle.deletar(formToAcervo());
		 System.out.println("Deletado com sucesso");
			}
		});
		
		btnDeletar.setBounds(230, 348, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		
		btnLimpar.setBounds(230, 380, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton voltar = new JButton("");
		
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormPrincipal fp = new FormPrincipal();
				fp.setVisible(true);
				dispose();
			}
		});
		
		voltar.setIcon(new ImageIcon("J:\\POO\\Controle de Museu\\Controle de MuseuV3\\back_icon.gif"));
		voltar.setBounds(453, 11, 27, 27);
		contentPane.add(voltar);
		
		txtId = new JTextField();
		txtId.setBounds(45, 3, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel id = new JLabel("Id");
		id.setBounds(10, 6, 46, 14);
		contentPane.add(id);
		
		
	}

	public void AcervoToForm(Acervo e) {
		txtId.setText(String.valueOf(e.getId()));
		txtNomeObra.setText(String.valueOf(e.getNome()));
		txtAutor.setText(String.valueOf(e.getAutor()));		
		txtEntrada.setText(sdf.format(e.getEntrada()));
		cmbTipo.setSelectedItem(String.valueOf(e.getTipo()));
		cmbStatus.setSelectedItem(String.valueOf(e.getStatus()));
		cmbCategoria.setSelectedItem(String.valueOf(e.getCategoria()));
		cmbItem.setSelectedItem(String.valueOf(e.getItem()));
	}

	public Acervo formToAcervo() {
		Acervo a = new Acervo();
		a.setId(Long.parseLong(txtId.getText()));
		a.setNome(txtNomeObra.getText());
		a.setAutor(txtAutor.getText());		
		a.setTipo(cmbTipo.getSelectedItem().toString());
		a.setStatus(cmbStatus.getSelectedItem().toString());
		a.setCategoria(cmbCategoria.getSelectedItem().toString());
		a.setItem(cmbItem.getSelectedItem().toString());
		try {
			a.setEntrada(sdf.parse(txtEntrada.getText()));			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return a;
	}
	
	public void limpar() {
		txtId.setText("");
		txtNomeObra.setText("");
		txtAutor.setText("");		
		txtEntrada.setText("");
		cmbTipo.setSelectedItem("");
		cmbStatus.setSelectedItem("");
		cmbCategoria.setSelectedItem("");
		cmbItem.setSelectedItem("");					
	}
}
