import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Test class for NaturalNumber calculator GUI (view in MVC).
 * 
 * @author Put your name here
 */
public final class NNCalcViewLab extends JFrame implements ActionListener {

    /**
     * Text areas.
     */
    private final JTextArea tTop, tBottom;
    
    /**
     * Operator and related buttons.
     */
    private final JButton bClear, bSwap, bEnter, bAdd, bSubtract, bMultiply,
            bDivide, bPower, bRoot;

    /**
     * Digit entry buttons.
     */
    //private final JButton[] bDigits;


    /**
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 5, TEXT_AREA_WIDTH = 20,
            DIGIT_BUTTONS = 10, MAIN_BUTTON_PANEL_GRID_ROWS = 4,
            MAIN_BUTTON_PANEL_GRID_COLUMNS = 4,
            SIDE_BUTTON_PANEL_GRID_ROWS = 3,
            SIDE_BUTTON_PANEL_GRID_COLUMNS = 1, CALC_GRID_ROWS = 3,
            CALC_GRID_COLUMNS = 1;

    /**
     * No-argument constructor.
     */
    public NNCalcViewLab() {

        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Natural Number Calculator");

        // Set up the GUI widgets --------------------------------------------

        // TODO: fill in rest of body, following outline in comments

        /*
         * Create widgets
         */

        // Set up the GUI widgets --------------------------------------------
        this.tTop = new JTextArea("",TEXT_AREA_HEIGHT,TEXT_AREA_WIDTH);
        this.tBottom = new JTextArea("",TEXT_AREA_HEIGHT,TEXT_AREA_WIDTH);
        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */
        this.tTop.setEditable(false);
        this.tTop.setLineWrap(true);
        this.tTop.setWrapStyleWord(true);
        this.tBottom.setEditable(false);
        this.tBottom.setLineWrap(true);
        this.tBottom.setWrapStyleWord(true);

        /*
         * Initially, the following buttons should be disabled: divide (divisor
         * must not be 0) and root (root must be at least 2) -- hint: see the
         * JButton method setEnabled
         */
        this.bDivide=new JButton("/");	
        this.bRoot = new JButton("root");
        this.bEnter= new JButton("Enter");
        this.bAdd= new JButton("+");
        this.bSubtract=new JButton("-");
        this.bMultiply=new JButton("*");
        this.bPower = new JButton("^");
        this.bClear = new JButton("clear");
        this.bSwap = new JButton("swap");

        /*
         * Create scroll panes for the text areas in case number is long enough
         * to require scrolling
         */
        JScrollPane topText = new JScrollPane(this.tTop);
        JScrollPane bottomText = new JScrollPane(this.tBottom);

        /*
         * Create main button panel
         */
        JPanel mainPanel = new JPanel(
        		new GridLayout(MAIN_BUTTON_PANEL_GRID_ROWS,MAIN_BUTTON_PANEL_GRID_COLUMNS));

        /*
         * Add the buttons to the main button panel, from left to right and top
         * to bottom
         */
        mainPanel.add(bAdd);
        mainPanel.add(bSubtract);
        mainPanel.add(bMultiply);
        mainPanel.add(bDivide);
        /*
         * Create side button panel
         */
        JPanel sideButton = new JPanel(
        		new GridLayout(SIDE_BUTTON_PANEL_GRID_ROWS,SIDE_BUTTON_PANEL_GRID_COLUMNS));

        /*
         * Add the buttons to the side button panel, from left to right and top
         * to bottom
         * 
         */
        sideButton.add(bClear);
        sideButton.add(bSwap);
        sideButton.add(bEnter);

        /*
         * Create combined button panel organized using flow layout, which is
         * simple and does the right thing: sizes of nested panels are natural,
         * not necessarily equal as with grid layout
         */
        
        /*
         * Add the other two button panels to the combined button panel
         */

        /*
         * Organize main window
         */
        this.setLayout(new GridLayout(CALC_GRID_ROWS,CALC_GRID_COLUMNS));
        
        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(topText);
        this.add(bottomText);
        this.add(mainPanel);
        this.add(sideButton);

        // Set up the observers ----------------------------------------------
        
        /*
         * Register this object as the observer for all GUI events
         */
        this.bAdd.addActionListener(this);
        this.bClear.addActionListener(this);
        this.bDivide.addActionListener(this);
        this.bEnter.addActionListener(this);
        this.bMultiply.addActionListener(this);
        this.bPower.addActionListener(this);
        this.bSubtract.addActionListener(this);
        this.bSwap.addActionListener(this);
        // Set up the main application window --------------------------------
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(this,
                "You pressed: " + event.getActionCommand());
    }

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        NNCalcViewLab view = new NNCalcViewLab();
    }

}