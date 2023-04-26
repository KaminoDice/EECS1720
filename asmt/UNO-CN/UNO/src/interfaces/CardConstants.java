package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.nio.channels.SeekableByteChannel;

import controller.GameModeListener;
import controller.MyButtonListener;
import controller.MyCardListener;
import controller.UserMenuListener;
import controller.UserPanelListener;
import view.InfoPanel;

public interface CardConstants {
	
	public static Color RED = new Color(192, 80, 77);
	
	public static Color BLUE = new Color(0, 0, 128);
	
	public static Color GREEN = new Color(34, 139, 34);
	
	public static Color YELLOW = new Color(255, 204, 0);
	
	public static Color BLACK = new Color(0, 0, 0);
	
	int VS_PC = 1;
	int MANUAL = 2;
	int[] GAMEMODES = {VS_PC, MANUAL};
	
	int WIDTH = 50;
	int HEIGHT = 65;
	Dimension CARDSIZE = new Dimension(WIDTH * 3, HEIGHT *3);
	
	
	public static final int NUMBER = 1;
	public static final int FUNCTION = 2;
	public static final int WILD = 3;

	
	Character CHAR_REVERSE = (char) 8634; 
	
	Character CHAR_SKIP = (char) Integer.parseInt("2718", 16); 

	
	String REVERSE = CHAR_REVERSE.toString();
	String SKIP = CHAR_SKIP.toString();
	String DRAW2PLUS = "+2";

	
	String W_COLORPICKER = "T";
	String W_DRAW4PLUS = "+4";

	MyCardListener CARDLISTENER = new MyCardListener();
	MyButtonListener BUTTONLISTENER = new MyButtonListener();
	UserPanelListener USERLISTRNER=new UserPanelListener();
	UserMenuListener MENULISTRNER=new UserMenuListener();
	GameModeListener MODELISTENER=new GameModeListener();
	
	int TOTALCARD = 108;
	
	int FIRDTHSND = 7;
	Color[] UNOCOLORS = { RED, BLUE, GREEN, YELLOW };
	Color WILDCARDCOLOR = BLACK;
	int[] UNONUMBERS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	String[] FUNCTIONTYPES = { REVERSE, SKIP, DRAW2PLUS }; 
	
	
	String[] WILDTYPES = { W_COLORPICKER, W_DRAW4PLUS }; 
	
	InfoPanel INFO_PANEL = new InfoPanel();
}
