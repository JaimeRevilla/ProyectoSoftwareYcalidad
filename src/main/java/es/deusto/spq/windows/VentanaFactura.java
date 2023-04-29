package es.deusto.spq.windows;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import es.deusto.spq.server.Carrito;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;


import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaFactura extends JFrame{
	private JList<Carrito> listaFactura;
	private DefaultListModel<Carrito> model;
	private JScrollPane panelLista;
	public static ArrayList<Carrito> carrito;
	
	
	public VentanaFactura(ArrayList<Carrito> carrito) {
		this.carrito = carrito;
		setBounds(250, 225, 1000, 508);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("ATRAS");
		
		panelSur.add(btnAtras);
		
		model = new DefaultListModel<>();
		listaFactura = new JList<>(model);
		panelLista = new JScrollPane(listaFactura);
		cargarModelo();
		
		getContentPane().add(panelLista, BorderLayout.CENTER);

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblFactura_1 = new JLabel("FACTURA");
		panelNorte.add(lblFactura_1);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		setVisible(true);
	}
	private void cargarModelo() {
		model.removeAllElements();
		for(Carrito c: carrito) {
			model.addElement(c);
		}
	}
	
}
