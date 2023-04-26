
import view.UserPanel;

public class Main {

	static UserPanel user;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() {
            	user=new UserPanel();
                
            }
        });
    }
}
