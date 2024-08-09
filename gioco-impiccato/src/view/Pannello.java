package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.UIManager;

import view.GraficaPannello.TipoSfondo;
import view.GraficaPannello.TipoTesto;

public class Pannello extends JPanel {

	static {
		UIManager.put("Button.highlight", GraficaPannello.ARANCIONE);
		UIManager.put("Button.select", GraficaPannello.ARANCIONE);
		UIManager.put("Button.focus", GraficaPannello.TRASPARENTE);
	}

	// usare factory pannelli?
	public enum TipoPannello {
		MENU, STATISTICHE, GIOCO, ESITO_PARTITA
	}

	private GraficaPannello grafica = new GraficaPannello();
	private static Color coloreSfondoDefault = Color.WHITE;

	public static final GraficaPannello GRAFICA_DEFAULT = new GraficaPannello(
			Map.of(TipoSfondo.PANNELLO, GraficaPannello.VERDE, TipoSfondo.BOTTONE, GraficaPannello.GIALLO,
					TipoTesto.TITOLO, GraficaPannello.ARANCIONE),
			Map.of(TipoTesto.TITOLO, new Font("Stencil", Font.PLAIN, 65), TipoTesto.BOTTONE, GraficaPannello.CORSIVO,
					TipoTesto.NORMALE, new Font("Calibri Light", Font.PLAIN, 40)));

	public Pannello() {
	}

	public Pannello(LayoutManager layout) {
		super(layout);
	}

	public Pannello(GraficaPannello grafica) {
		this.grafica = grafica;
	}

	public Pannello(LayoutManager layout, GraficaPannello grafica) {
		super(layout);
		this.grafica = grafica;
	}

	public GraficaPannello getGrafica() {
		return grafica;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int density = 5;
		g.setColor(grafica.getColori().getOrDefault(GraficaPannello.TipoSfondo.PANNELLO, coloreSfondoDefault));
		for (int x = 0; x <= getWidth() + getHeight(); x += density) {
			g.drawLine(x, 0, 0, x);
		}
	}
}
