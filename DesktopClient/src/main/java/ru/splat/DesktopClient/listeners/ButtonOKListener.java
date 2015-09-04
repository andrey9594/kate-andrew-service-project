package ru.splat.DesktopClient.listeners;


import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.splat.DesktopClient.Client;


/**
 * <p/>
 *
 * @author Ekaterina
 *         <p/>
 *         Listener of "OK" button that reads and save the entered value of the object identifier
 */
public class ButtonOKListener implements SelectionListener
{
    private static final Logger log = LoggerFactory.getLogger(JsonProviderListener.class);

    Client client;

    Text text;


    /**
     * Constructor of ButtonOKListener
     *
     * @param client object Client
     * @param text   text field on DC
     */
    public ButtonOKListener(Client client, Text text)
    {
        this.client = client;
        this.text = text;
    }


    /**
     * Method reads and save the entered value of the object identifier
     *
     * @param selectionEvent Pressing the button "OK"
     */
    @Override public void widgetSelected(SelectionEvent selectionEvent)
    {
        if (!text.getText().isEmpty())
            client.id = Integer.parseInt(text.getText());
        log.info("The entered value of the object identifier has been read and saved");
    }


    @Override public void widgetDefaultSelected(SelectionEvent selectionEvent)
    {

    }
}