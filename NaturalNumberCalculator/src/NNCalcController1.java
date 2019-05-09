import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Put your name here
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {
    	NaturalNumber top = model.top();
    	NaturalNumber bot = model.bottom();
    	if(bot.toString().equals("0")) {
    		view.updateDivideAllowed(false);
    	}else {
    		view.updateDivideAllowed(true);
    	}
    	if(bot.compareTo(TWO)<0) {
    		view.updateRootAllowed(false);
    	}else {
    		view.updateRootAllowed(true);
    	}
    	if(bot.compareTo(top)>0) {
    		view.updateSubtractAllowed(false);
    	}else {
    		view.updateSubtractAllowed(true);
    	}
    	if(bot.compareTo(INT_LIMIT)>0) {
    		view.updatePowerAllowed(false);
    		view.updateRootAllowed(false);
    	}else {
    		view.updatePowerAllowed(true);
    		view.updatePowerAllowed(true);
    	}
    	view.updateTopDisplay(model.top());
    	view.updateBottomDisplay(model.bottom());
    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.transferFrom(bottom);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);
    }

    @Override
    public void processAddEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber plus = top.newInstance();
        plus.transferFrom(top);
        bottom.add(plus);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

    @Override
    public void processSubtractEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber minus = top.newInstance();
        minus.transferFrom(top);
        bottom.subtract(minus);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

    @Override
    public void processMultiplyEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber multiply = top.newInstance();
        multiply.transferFrom(top);
        bottom.multiply(multiply);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

    @Override
    public void processDivideEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber divide = top.newInstance();
        divide.transferFrom(top);
        bottom.divide(divide);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

    @Override
    public void processPowerEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber power = top.newInstance();
        power.transferFrom(top);
        bottom.power(power.toInt());
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

    @Override
    public void processRootEvent() {
    	/*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber root = top.newInstance();
        root.transferFrom(top);
        bottom.root(root.toInt());
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {
    	/*
         * Get aliases to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.multiplyBy10(digit);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model,this.view);

    }

}
