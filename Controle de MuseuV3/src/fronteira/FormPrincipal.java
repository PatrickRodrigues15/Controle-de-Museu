package fronteira;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import fronteira.FormEmprestimo;

;

public class FormPrincipal extends JFrame {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 376);
		setTitle("Menu");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("J:\\POO\\Controle de Museu\\Controle de MuseuV3\\foto-galeria-materia-620-w5.jpeg"));
		lblNewLabel.setBounds(-10, 0, 522, 306);
		getContentPane().add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuP = new JMenu("Obras");
		menuBar.add(menuP);

		JMenuItem mntmCadastroAcervo = new JMenuItem("Cadastrar Acervo");
		
		mntmCadastroAcervo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAcervo fa = new FormAcervo();
				fa.setVisible(true);
				dispose();
			}
		});

		menuP.add(mntmCadastroAcervo);
		JMenuItem menuItem3 = new JMenuItem("Sair");
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuP.add(menuItem3);

		JMenu mnNewMenu = new JMenu("");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Emprestimo");
		mnNewMenu.add(mntmNewMenuItem);

		JMenu MenuP = new JMenu("Museu Dados");
		menuBar.add(MenuP);

		JMenuItem menu1 = new JMenuItem("Emprestimo");
		MenuP.add(menu1);

		JMenuItem menu2 = new JMenuItem("Exposição");
		MenuP.add(menu2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Visitantes");

		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormVisitantes fv = new FormVisitantes();
				fv.setVisible(true);
				dispose();
			}
		});

		MenuP.add(mntmNewMenuItem_3);

		JMenu menu4 = new JMenu("Sobre");
		menuBar.add(menu4);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Componentes");
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormComponentes fc = new FormComponentes();
				fc.setVisible(true);
				dispose();
			}
		});
		
		menu4.add(mntmNewMenuItem_1);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);

		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormEmprestimo f = new FormEmprestimo();
				f.setVisible(true);
				dispose();

			}
		});

		
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormExposicao f = new FormExposicao();
				f.setVisible(true);
				dispose();
			}
		});
	}
}
