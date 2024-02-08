package fronteira;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ExposicaoController;
import entidade.Exposicao;

import javax.swing.ImageIcon;

public class FormExposicao extends JFrame  {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPrecoIngresso;
	private JTextField txtCusto;
	private JTextField txtSala;
	private JTextField txtInicio;
	private JTextField txtTermino;
	private JTextField txtId;
	private JTextField txtArtista;
	private JComboBox cmbImagem;
	private JComboBox cmbItinerante;
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
	ExposicaoController controle = new ExposicaoController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormExposicao frame = new FormExposicao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormExposicao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 496);
		setTitle("Exposição");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Nome");
		label.setBounds(10, 45, 118, 14);
		contentPane.add(label);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 70, 194, 20);
		contentPane.add(txtNome);

		JLabel label_1 = new JLabel("Nome(s) do(s) artista(s)");
		label_1.setBounds(10, 101, 118, 14);
		contentPane.add(label_1);

		JTextArea txtArtista = new JTextArea();
		txtArtista.setWrapStyleWord(true);
		txtArtista.setLineWrap(true);
		txtArtista.setBounds(10, 126, 194, 59);
		contentPane.add(txtArtista);

		JLabel label_2 = new JLabel("Pre\u00E7o do Ingresso");
		label_2.setBounds(10, 196, 118, 14);
		contentPane.add(label_2);

		txtPrecoIngresso = new JTextField();
		txtPrecoIngresso.setColumns(10);
		txtPrecoIngresso.setBounds(10, 217, 86, 20);
		contentPane.add(txtPrecoIngresso);

		JLabel label_3 = new JLabel("Custo");
		label_3.setBounds(10, 257, 118, 14);
		contentPane.add(label_3);

		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		txtCusto.setBounds(10, 275, 86, 20);
		contentPane.add(txtCusto);

		JLabel label_4 = new JLabel("Uso de imagem e som");
		label_4.setBounds(10, 306, 161, 14);
		contentPane.add(label_4);

		final JComboBox cmbImagem = new JComboBox();
		cmbImagem.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cmbImagem.setBounds(10, 331, 86, 20);
		contentPane.add(cmbImagem);

		JLabel lblObraItinerante = new JLabel("Obra itinerante");
		lblObraItinerante.setBounds(10, 362, 118, 14);
		contentPane.add(lblObraItinerante);

		JComboBox cmbItinerante = new JComboBox();
		cmbItinerante.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "N\u00E3o"}));
		cmbItinerante.setBounds(10, 387, 86, 20);
		contentPane.add(cmbItinerante);

		JLabel label_6 = new JLabel("Sala(s)");
		label_6.setBounds(352, 45, 118, 14);
		contentPane.add(label_6);

		txtSala = new JTextField();
		txtSala.setColumns(10);
		txtSala.setBounds(350, 70, 86, 20);
		contentPane.add(txtSala);

		JLabel label_7 = new JLabel("In\u00EDcio");
		label_7.setBounds(352, 101, 167, 14);
		contentPane.add(label_7);

		txtInicio = new JTextField();
		txtInicio.setBounds(352, 126, 86, 22);
		contentPane.add(txtInicio);
		txtInicio.setColumns(10);

		JLabel label_8 = new JLabel("T\u00E9rmino");
		label_8.setBounds(352, 171, 118, 14);
		contentPane.add(label_8);

		txtTermino = new JTextField();
		txtTermino.setBounds(352, 193, 86, 20);
		contentPane.add(txtTermino);
		txtTermino.setColumns(10);

		JLabel label_9 = new JLabel("Descri\u00E7\u00E3o");
		label_9.setBounds(331, 245, 118, 14);
		contentPane.add(label_9);

		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setLineWrap(true);
		txtDescricao.setBounds(331, 273, 220, 78);
		contentPane.add(txtDescricao);

		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			List<Exposicao> lista = controle.pesquisar( txtNome.getText() );
			if (lista.size() > 0) {
				ExposicaoToForm(lista.get(0));
			}
			}
		});
		
		
		btnPesquisar.setBounds(331, 403, 89, 23);
		contentPane.add(btnPesquisar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.deletar(formToExposicao());
				System.out.println("Deltado com sucesso");
			}
		});
		
		btnDeletar.setBounds(240, 403, 89, 23);
		contentPane.add(btnDeletar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.adicionar(formToExposicao());
				System.out.println("Teste" + "\n" + txtNome.getText() + "\n"
						+ txtId.getText() + "\n" + cmbImagem.getSelectedItem());
			}
		});

		btnAdicionar.setBounds(141, 403, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.alterar(formToExposicao());
	               System.out.println("Alterado com sucesso!");	 	
			}
		});
		btnAlterar.setBounds(430, 403, 89, 23);
		contentPane.add(btnAlterar);

		txtId = new JTextField();
		txtId.setBounds(49, 14, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel Id = new JLabel("Id");
		Id.setBounds(16, 17, 46, 14);
		contentPane.add(Id);
		
		JButton btnLimpar = new JButton("Limpar");
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(529, 403, 89, 23);
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
		voltar.setBounds(578, 14, 27, 27);
		contentPane.add(voltar);
	}
	
	public void ExposicaoToForm(Exposicao e) {

		txtId.setText(String.valueOf(e.getId()));
		txtNome.setText(String.valueOf(e.getNome()));
		txtArtista.setText(String.valueOf(e.getArtista()));
		txtPrecoIngresso.setText(String.valueOf(e.getPreco()));
		txtCusto.setText(String.valueOf(e.getCusto()));
		txtSala.setText(String.valueOf(e.getSala()));
		txtInicio.setText(sdf.format(e.getInicio()));
		txtTermino.setText(sdf.format(e.getFim()));
		cmbImagem.setSelectedItem(String.valueOf(e.getImagem()));
		cmbItinerante.setSelectedItem(String.valueOf(e.getItinerante()));
	}

	public Exposicao formToExposicao() {
		Exposicao e = new Exposicao();
		e.setId(Long.parseLong(txtId.getText()));
		e.setNome(txtNome.getText());
		e.setArtista(txtArtista.getText());
		e.setPreco(Double.parseDouble(txtPrecoIngresso.getText()));
		e.setCusto(Double.parseDouble(txtCusto.getText()));
		e.setSala(Integer.parseInt(txtSala.getText()));
		e.setImagem(cmbImagem.getSelectedItem().toString());
		e.setItinerante(cmbItinerante.getSelectedItem().toString());

		try {
			e.setInicio(sdf.parse(txtInicio.getText()));
			e.setFim(sdf.parse(txtTermino.getText()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		return e;
	}
	
	public void limpar() {
		txtId.setText("");
		txtNome.setText("");
		txtPrecoIngresso.setText("");
		txtCusto.setText("");
		txtSala.setText("");
		txtInicio.setText("");
		txtTermino.setText("");
		txtArtista.setText("");
		cmbImagem.setSelectedItem("");
		cmbItinerante.setSelectedItem("");					
	}
	

}
