package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GiocoImpiccato;

public class PannelloMenu extends Pannello {

	private JLabel titolo;
	private JLabel immagine;
	private JButton bottoneGioco;
	private JButton bottoneStatistiche;

	private static String nomeGioco = "<html>Gioco<br>dell'impiccato</html>";
	private static String pathImmagine = "assets/forest.png";
	private static String indicazioneGioco = "Gioca";
	private static String indicazioneStatistiche = "Statistiche";
	private static LayoutManager layout = new GridLayout(1, 2, 40, 0);

	public PannelloMenu(GiocoImpiccato modello) {
		this(modello, GRAFICA_DEFAULT);
	}

	public PannelloMenu(GiocoImpiccato modello, GraficaPannello grafica) {

		super(modello, layout, grafica);
		titolo = grafica.creaTitolo(nomeGioco);
		immagine = grafica.creaImmagine(pathImmagine);
		bottoneGioco = grafica.creaBottone(indicazioneGioco);
		bottoneStatistiche = grafica.creaBottone(indicazioneStatistiche);

		inizializzaPannelloMenu();
	}

	private void inizializzaPannelloMenu() {
		setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		add(immagine);
		add(creaPannelloPulsanti());
	}

	private JPanel creaPannelloPulsanti() {
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints disp = GraficaPannello.generaDisposizione(0, 3, 1, 1, GridBagConstraints.SOUTH);
		p.add(titolo, disp);
		disp = GraficaPannello.generaDisposizione(0, 4, 1, 1, GridBagConstraints.CENTER);
		p.add(bottoneGioco, disp);
		disp = GraficaPannello.generaDisposizione(0, 5, 1, 1, GridBagConstraints.NORTH);
		p.add(bottoneStatistiche, disp);
		p.setBackground(new Color(0, 0, 0, 0));
		return p;
	}

	public JLabel getTitolo() {
		return titolo;
	}

	public JLabel getImmagine() {
		return immagine;
	}

	public JButton getBottoneGioco() {
		return bottoneGioco;
	}

	public JButton getBottoneStatistiche() {
		return bottoneStatistiche;
	}

}
