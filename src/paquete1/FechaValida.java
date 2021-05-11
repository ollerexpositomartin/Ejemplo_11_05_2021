package paquete1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FechaValida {

	public static void main(String[] args) {
		Ventana ventana =new Ventana();
		ventana.setVisible(true);

	}

}

class Ventana extends JFrame implements ActionListener {
	JTextField dia;
	JTextField mes;
	JTextField anio;
	JLabel etDia;
	JLabel etMes;
	JLabel etAnio;
	JLabel etValida;
	JButton btValidar;

	public Ventana() {
		super("Fecha");
		setBounds(10, 10, 375, 150);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		etDia = new JLabel("Dia");
		etDia.setFont(new Font("Arial", 0, 15));
		etDia.setBounds(20, 10, 100, 20);

		etMes = new JLabel("Mes");
		etMes.setFont(new Font("Arial", 0, 15));
		etMes.setBounds(90, 10, 100, 20);

		etAnio = new JLabel("Año");
		etAnio.setFont(new Font("Arial", 0, 15));
		etAnio.setBounds(170, 10, 100, 20);

		dia = new JTextField();
		dia.setBounds(10, 35, 50, 20);

		mes = new JTextField();
		mes.setBounds(80, 35, 50, 20);

		anio = new JTextField();
		anio.setBounds(160, 35, 50, 20);

		btValidar = new JButton("Validar");
		btValidar.setBounds(240, 35, 100, 20);
		btValidar.addActionListener(this);

		etValida = new JLabel();
		etValida.setFont(new Font("Arial", 1, 16));
		etValida.setBounds(10, 75, 250, 20);

		add(etDia);
		add(etMes);
		add(etAnio);
		add(dia);
		add(mes);
		add(anio);
		add(btValidar);
		add(etValida);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String diaString;
		int diaEntero = 0;

		String mesString;
		int mesEntero = 0;

		String anioString;
		int anioEntero = 0;

		boolean formatoValido = true;

		if (e.getSource() == btValidar)

			try {
				diaString = dia.getText().toString().trim();
				diaEntero = Integer.parseInt(diaString);

			} catch (Exception e2) {
				etValida.setText("El Valor de Dia no es un numero");
				formatoValido = false;
			}

		try {
			mesString = mes.getText().toString().trim();
			mesEntero = Integer.parseInt(mesString);

		} catch (Exception e2) {
			etValida.setText("El Valor de mes no es un numero");
			formatoValido = false;
		}

		try {
			anioString = anio.getText().toString().trim();
			anioEntero = Integer.parseInt(anioString);

		} catch (Exception e2) {
			etValida.setText("El Valor de año no es un numero");
			formatoValido = false;
		}

		if (formatoValido == true) {
			if (validarFecha(diaEntero, mesEntero, anioEntero) == true)
				etValida.setText(diaEntero+" del "+mesEntero+" de "+anioEntero);
			else
				etValida.setText("LA FECHA ES INVALIDA");
		}

	}

	private boolean validarFecha(int dia, int mes, int anio) {

		int diaMax = 0;
		boolean valida = true;

		switch (mes) {
		case 1, 3, 5, 7, 8, 10, 12: {
			diaMax = 31;
		}
			break;
		case 4, 6, 9, 11: {
			diaMax = 30;

		}
			break;
		case 2: {
			if (anio % 4 == 0 && (anio%400==0 || anio%100!=0))
				diaMax = 29;
			else
				diaMax = 28;
		}
			break;

		}

		if (dia > diaMax || dia < 1)
			valida = false;
		else if (mes > 12 || mes < 1)
			valida = false;
		else if (anio > 2021 || anio < 2000)
			valida = false;

		return valida;

	}
}
