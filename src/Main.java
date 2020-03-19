import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;


/**
 * 
 * @author andrei portales 19825
 *
 */

public class Main {

	private JFrame frame;
	private JTextArea txtIngles,txtEspanol,txtInOrder;
	private Controlador control;
	private JButton btnTraducir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		control = new Controlador();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1177, 704);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar Diccionario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				control.crearDiccionario();
				txtIngles.setEnabled(true);
				txtEspanol.setEnabled(true);
				btnTraducir.setEnabled(true);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al crear diccionario");
				}
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(12, 13, 164, 43);
		frame.getContentPane().add(btnNewButton);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(169, 90, 426, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtIngles = new JTextArea();
		txtIngles.setLineWrap(true);
		txtIngles.setBounds(12, 13, 402, 164);
		panel.add(txtIngles);
		txtIngles.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Ingles");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(349, 52, 90, 25);
		frame.getContentPane().add(lblNewLabel);
		
		btnTraducir = new JButton("Traducir");
		btnTraducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (txtIngles.getText().length() > 0) {
						txtEspanol.setText(control.traducir(txtIngles.getText()));
					}
				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al traducir");
				}
			}
		});
		btnTraducir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTraducir.setBackground(Color.LIGHT_GRAY);
		btnTraducir.setBounds(299, 293, 164, 42);
		frame.getContentPane().add(btnTraducir);
		btnTraducir.setEnabled(false);
		
		JLabel lblEspanol = new JLabel("Espanol");
		lblEspanol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEspanol.setBounds(349, 363, 90, 25);
		frame.getContentPane().add(lblEspanol);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(169, 401, 426, 190);
		frame.getContentPane().add(panel_1);
		
		txtEspanol = new JTextArea();
		txtEspanol.setLineWrap(true);
		txtEspanol.setBounds(12, 13, 402, 164);
		panel_1.add(txtEspanol);
		txtEspanol.setEnabled(false);
		
		JLabel lblInOrder = new JLabel("In - Order");
		lblInOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInOrder.setBounds(666, 52, 116, 25);
		frame.getContentPane().add(lblInOrder);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(634, 13, 20, 631);
		frame.getContentPane().add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(667, 90, 426, 497);
		frame.getContentPane().add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 402, 471);
		panel_2.add(scrollPane);
		
		txtInOrder = new JTextArea();
		scrollPane.setViewportView(txtInOrder);
		txtInOrder.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtInOrder.setLineWrap(true);
		txtInOrder.setEditable(false);
		
		
		JButton btnNewButton_1 = new JButton("Mostrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stack<String> data = control.inOrder();
				String info = "";
				int ii= data.size();
				for (int i = 1; i<= ii;i++) {
					info += data.pop();
				}
				txtInOrder.setText(info);
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(996, 55, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}
