package fronteira;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.VisitantesController;
import entidade.Visitantes;

public class FormVisitantes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtData;
	private JTextField txtNac;
	private JTextField txtId;
	private JComboBox cmbSexo;
	private JComboBox cmbVisitas;
	
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton btnLimpar;
	SimpleDateFormat sdf  = new SimpleDateFormat();
	VisitantesController controle = new VisitantesController();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormVisitantes frame = new FormVisitantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public FormVisitantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 373);
		setTitle("Visitantes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(20, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 69, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel endereco = new JLabel("Endere\u00E7o");
		endereco.setBounds(20, 100, 46, 14);
		contentPane.add(endereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(20, 125, 202, 17);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		final JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		cmbSexo.setBounds(20, 178, 86, 20);
		contentPane.add(cmbSexo);
		
		JLabel label = new JLabel("Sexo");
		label.setBounds(20, 153, 81, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Data de nascimento");
		label_1.setBounds(20, 209, 159, 14);
		contentPane.add(label_1);
		
		txtData = new JTextField();
		txtData.setBounds(20, 234, 96, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel label_2 = new JLabel("Nacionalidade");
		label_2.setBounds(274, 44, 102, 14);
		contentPane.add(label_2);
		
		txtNac = new JTextField();
		txtNac.setColumns(10);
		txtNac.setBounds(274, 69, 102, 20);
		contentPane.add(txtNac);
		
		JLabel label_3 = new JLabel("Frequ\u00EAncia de visitas");
		label_3.setBounds(271, 100, 150, 14);
		contentPane.add(label_3);
		
		JComboBox cmbVisitas = new JComboBox();
		cmbVisitas.setModel(new DefaultComboBoxModel(new String[] {"", "Semanalmente", "Mensalmente", "Anualmente"}));
		cmbVisitas.setBounds(271, 125, 102, 20);
		contentPane.add(cmbVisitas);
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.adicionar(formToVisitantes());
				System.out.println("Teste evento" + "\n" + txtNome.getText()
						+ "\n" + txtId.getText() + "\n" + cmbSexo.getSelectedItem());
				
			}
		});
		
		
		btnAdicionar.setBounds(274, 205, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Visitantes> lista = controle.pesquisar( txtNome.getText() );
				if (lista.size() > 0) {
					VisitantesToForm(lista.get(0));
				}
				
			}
		});
		btnPesquisar.setBounds(274, 233, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				   				
			controle.alterar(formToVisitantes());
	               System.out.println("Alterado com sucesso!");	 	                   				
			}
		});
		
		btnAlterar.setBounds(274, 267, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.deletar(formToVisitantes());
	               System.out.println("Deletado com sucesso!");	 	       
			}
		});
		
		btnDeletar.setBounds(274, 301, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		
		btnLimpar.setBounds(20, 267, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormPrincipal fp = new FormPrincipal();
				fp.setVisible(true);
				dispose();
			}
		});
		
		btnVoltar.setIcon(new ImageIcon("J:\\POO\\Controle de Museu\\Controle de MuseuV3\\back_icon.gif"));
		btnVoltar.setBounds(445, 11, 27, 27);
		contentPane.add(btnVoltar);
		
		txtId = new JTextField();
		txtId.setBounds(62, 19, 86, 14);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel Id = new JLabel("Id");
		Id.setBounds(20, 19, 46, 14);
		contentPane.add(Id);
	}
	
	public void VisitantesToForm(Visitantes v) {

		txtId.setText(String.valueOf(v.getId() ) );
		txtNome.setText(String.valueOf(v.getNome() ) );
		txtEndereco.setText(String.valueOf(v.getEndereco()));
		txtData.setText(sdf.format(v.getDtNasc()));
		txtNac.setText(String.valueOf(v.getNacionalidade()));
		cmbSexo.setSelectedItem(v.getSexo());						
	}

	public Visitantes formToVisitantes() {
		Visitantes v = new Visitantes();
		v.setId(Long.parseLong(txtId.getText()));
		v.setNome(txtNome.getText());
		v.setEndereco(txtEndereco.getText());
		v.setNacionalidade(txtNac.getText());
		v.setSexo(cmbSexo.getSelectedItem().toString());
		v.setFrequencia(cmbVisitas.getSelectedItem().toString());		
		try {
			v.setDtNasc(sdf.parse(txtData.getText()));			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return v;
	}
	
	public void limpar() {
		txtId.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtData.setText("");
		txtNac.setText("");
		cmbSexo.setSelectedItem("");
		cmbVisitas.setSelectedItem("");				
	}	
	
	
}
