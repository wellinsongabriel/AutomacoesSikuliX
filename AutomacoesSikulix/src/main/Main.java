package main;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class Main {

	private static Screen screen = new Screen();

	public static void main(String[] args) {
		exemploAutomocaoRotina();
	}

	private static void exemploAutomocaoRotina() {

		if (Key.isLockOn(Key.C_CAPS_LOCK))
			screen.type(Key.CAPS_LOCK);
		teclarBotaoWindows();
		escreverEnter("spotify");

		executarAtalho(Arrays.asList(Key.WIN, "r"));
		escreverEnter("chrome");

		executarAtalho(Arrays.asList(Key.WIN, "r"));
		escreverEnter("ms-settings:network-vpn");
		screen.wait(3d);
		screen.type(Key.TAB);
		screen.type(Key.ENTER);
		screen.type(Key.TAB);
		screen.type(Key.ENTER);

		executarAtalho(Arrays.asList(Key.CTRL, Key.WIN, Key.RIGHT));
	}

	private static void escreverEnter(String texto) {
		screen.wait(2d);
		screen.type(texto);
		screen.wait(1d);
		screen.type(Key.ENTER);
	}

	private static void moverMouseTela(int x, int y, boolean clicar) {
		System.out.println(screen.getNumberScreens());
		System.out.println(screen.getScreen(0));
		System.out.println(screen.getScreen(1));

		Region region = new Region(x, y);

		region.hover();
		screen.wait(2d);
		if (clicar)
			region.click();
	}

	private static void clicarNaImagem(String nomeImagem) {
		try {
			File imagem = new File("imagens/" + nomeImagem + ".png");
			Pattern imagemBotao = new Pattern(imagem.getAbsolutePath());

			screen.wait(imagemBotao, 2d);

			screen.click();
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	private static void executarAtalho(List<String> teclas) {
		screen.wait(2d);
		teclas.forEach(t -> screen.keyDown(t));
		teclas.forEach(t -> screen.keyUp(t));
	}

	private static void teclarBotaoWindows() {
		screen.keyDown(Key.WIN);
		screen.keyUp(Key.WIN);
	}

}
