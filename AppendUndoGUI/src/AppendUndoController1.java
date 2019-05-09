/**
 * Controller class.
 * 
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public final class AppendUndoController1 implements AppendUndoController {

    /**
     * Model object.
     */
    private final AppendUndoModel model;

    /**
     * View object.
     */
    private final AppendUndoView view;

    /**
     * Updates view to display model.
     * 
     * @param model
     *            the model
     * @param view
     *            the view
     */
    private static void updateViewToMatchModel(AppendUndoModel model, AppendUndoView view) {
        /*
         * Get model info
         */
        String input = model.input();
        String output = model.output().toString();
        if(model.output().length()==0) {
        	view.updateUndoAllowed(false);
        }else {
        	view.updateUndoAllowed(true);
        }
       
        /*
         * Update view to reflect changes in model
         */
        view.updateInputDisplay(input);
        view.updateOutputDisplay(output);
    }

    /**
     * Constructor; connects {@code this} to the model and view it coordinates.
     * 
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public AppendUndoController1(AppendUndoModel model, AppendUndoView view) {
        this.model = model;
        this.view = view;
        /*
         * Update view to reflect initial value of model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes reset event.
     */
    @Override
    public void processResetEvent() {
        /*
         * Update model in response to this event
         */
        this.model.setInput("");
        this.model.output().clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes copy event.
     * 
     * @param input
     *            value of input text (provided by view)
     */
    @Override
    public void processAppendEvent(String input) {
        /*
         * Update model in response to this event
         */
        this.model.setInput("");
        this.model.output().push(input);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }
    /**
     * reverts the output text area to the state before
     * the last append and replaces the input text area 
     * with the text removed from the output
     */
    @Override
    public void processUndoEvent() {
    	String text =this.model.output().pop();
    	this.model.setInput(text);
    	this.updateViewToMatchModel(model, view);
    }

}
