package fronteira;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EmprestimoController;
import entidade.Emprestimo;

import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;

public class FormEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtAutor;
	private JTextField txtAluguel;
	private JTextField txtPrecoObra;
	private JTextField txtSeguradora;
	private JTextField txtEmprestimo;
	private JTextField txtTermino;
	private JTextField txtId;
	private JComboBox cmbExposicao;
	private JComboBox cmbObra;

	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	SimpleDateFormat sdf = new SimpleDateFormat("dd//mm/yyyy");
	EmprestimoController controle = new EmprestimoController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEmprestimo frame = new FormEmprestimo();
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
	public FormEmprestimo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 442);
		setTitle("Emprestimo");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Nome");
		label.setBounds(10, 34, 90, 14);
		contentPane.add(label);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 59, 160, 20);
		contentPane.add(txtNome);

		JLabel label_1 = new JLabel("Autor");
		label_1.setBounds(10, 90, 90, 14);
		contentPane.add(label_1);

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(10, 115, 165, 20);
		contentPane.add(txtAutor);

		JLabel label_2 = new JLabel("Tipo de obra");
		label_2.setBounds(10, 166, 90, 14);
		contentPane.add(label_2);

		final JComboBox cmbObra = new JComboBox();
		cmbObra.setModel(new DefaultComboBoxModel(new String[] {"", "Pinturas", "Esculturas", "Gravuras", "Desenhos", "Fotografia", "Arqueologia"}));
		cmbObra.setBounds(10, 191, 143, 20);
		contentPane.add(cmbObra);

		JLabel label_3 = new JLabel("Pre\u00E7o do aluguel");
		label_3.setBounds(10, 222, 143, 14);
		contentPane.add(label_3);

		txtAluguel = new JTextField();
		txtAluguel.setColumns(10);
		txtAluguel.setBounds(10, 240, 86, 20);
		contentPane.add(txtAluguel);

		JLabel label_4 = new JLabel("Pre\u00E7o da obra");
		label_4.setBounds(10, 271, 90, 14);
		contentPane.add(label_4);

		txtPrecoObra = new JTextField();
		txtPrecoObra.setColumns(10);
		txtPrecoObra.setBounds(10, 291, 79, 20);
		contentPane.add(txtPrecoObra);

		JLabel label_5 = new JLabel("Seguradora");
		label_5.setBounds(10, 322, 90, 14);
		contentPane.add(label_5);

		txtSeguradora = new JTextField();
		txtSeguradora.setColumns(10);
		txtSeguradora.setBounds(10, 341, 86, 20);
		contentPane.add(txtSeguradora);

		JLabel label_6 = new JLabel("Data de in\u00EDcio do empr\u00E9stimo");
		label_6.setBounds(332, 24, 188, 14);
		contentPane.add(label_6);

		txtEmprestimo = new JTextField();
		txtEmprestimo.setBounds(332, 49, 102, 20);
		contentPane.add(txtEmprestimo);
		txtEmprestimo.setColumns(10);

		txtTermino = new JTextField();
		txtTermino.setColumns(10);
		txtTermino.setBounds(332, 115, 102, 20);
		contentPane.add(txtTermino);

		JLabel label_7 = new JLabel("Data de t\u00E9rmino do empr\u00E9stimo");
		label_7.setBounds(332, 90, 188, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("Item em exposi\u00E7\u00E3o");
		label_8.setBounds(332, 166, 135, 14);
		contentPane.add(label_8);

		JComboBox cmbExposicao = new JComboBox();
		cmbExposicao.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cmbExposicao.setBounds(332, 191, 90, 20);
		contentPane.add(cmbExposicao);

		JButton btnAdicionar = new JButton("Adicionar");

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 controle.adicionar(formToEmprestimo());
				System.out.println("Teste evento" + "\n" + txtNome.getText()
						+ "\n" + txtId.getText() + "\n"
						+ cmbObra.getSelectedItem());
				
			}
		});

		btnAdicionar.setBounds(332, 262, 102, 20);
		contentPane.add(btnAdicionar);

		JButton btnPesquisar = new JButton("Pesquisar");		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Emprestimo> lista = controle.pesquisar( txtNome.getText() );
				if (lista.size() > 0) {
					EmprestimoToForm(lista.get(0));
				}
				}
				
		});

		btnPesquisar.setBounds(333, 290, 101, 20);
		contentPane.add(btnPesquisar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.alterar(formToEmprestimo());
				System.out.println("Deltado com sucesso");
			}
		});
		btnAlterar.setBounds(332, 318, 102, 18);
		contentPane.add(btnAlterar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.deletar(formToEmprestimo());
				System.out.println("Deltado com sucesso");
			}
		});
		btnDeletar.setBounds(332, 341, 101, 20);
		contentPane.add(btnDeletar);

		txtId = new JTextField();
		txtId.setBounds(46, 6, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 9, 46, 14);
		contentPane.add(lblNewLabel);

		JButton btnLimpar = new JButton("Limpar");
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(332, 370, 102, 23);
		contentPane.add(btnLimpar);

		JButton voltar = new JButton("");
		voltar.setIcon(new ImageIcon("J:\\POO\\Controle de Museu\\Controle de MuseuV3\\back_icon.gif"));

		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormPrincipal fp = new FormPrincipal();
				fp.setVisible(true);
				dispose();
			}
		});

		voltar.setBounds(496, 6, 24, 23);
		contentPane.add(voltar);

	}

	public void EmprestimoToForm(Emprestimo e) {

		txtId.setText(String.valueOf(e.getId()));
		txtNome.setText(String.valueOf(e.getNome()));
		txtAutor.setText(String.valueOf(e.getAutor()));
		txtAluguel.setText(String.valueOf(e.getAluguel()));
		txtPrecoObra.setText(String.valueOf(e.getPrecoObra()));
		txtSeguradora.setText(String.valueOf(e.getSeguradora()));
		txtEmprestimo.setText(String.valueOf(e.getEmprestimo()));
		txtTermino.setText(String.valueOf(e.getTermino()));
		txtEmprestimo.setText(sdf.format(e.getEmprestimo()));
		cmbObra.setSelectedItem(e.getObra());
	}

	public Emprestimo formToEmprestimo() {
		Emprestimo e = new Emprestimo();
		e.setId(Long.parseLong(txtId.getText()));
		e.setNome(txtNome.getText());
		e.setAutor(txtAutor.getText());
		e.setAluguel(Double.parseDouble(txtAluguel.getText()));
		e.setPrecoObra(Double.parseDouble(txtPrecoObra.getText()));
		e.setSeguradora(txtSeguradora.getText());
		e.setExposicao(cmbExposicao.getSelectedItem().toString());
		e.setObra(cmbObra.getSelectedItem().toString());
		try {
			e.setEmprestimo(sdf.parse(txtEmprestimo.getText()));
			e.setTermino(sdf.parse(txtTermino.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	public void limpar() {
		txtId.setText("");
		txtNome.setText("");
		txtAutor.setText("");
		txtAluguel.setText("");
		txtPrecoObra.setText("");
		txtSeguradora.setText("");
		txtEmprestimo.setText("");
		txtTermino.setText("");
		cmbExposicao.setSelectedItem("");
		cmbObra.setSelectedItem("");
		
	}
	
	
}
