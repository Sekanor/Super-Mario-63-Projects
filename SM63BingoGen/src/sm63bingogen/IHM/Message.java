/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm63bingogen.IHM;

import java.util.HashMap;

/**
 *
 * @author Kévin
 */
public class Message {
    
    // Unique instance of the Message class.
    private static Message instance;
    
    // List of messages, which link a string to another string
    private HashMap<String, String> messageList;
    
    /**
     * Constructor of the Message class.
     */
    private Message() {
        this.messageList = new HashMap<>();
        
        addMessage("title","SM63BingoGen 1.0.1");
        
        addMessage("about", "\nSuper Mario 63 Bingo Generator version 1.0.1.\n"
                + "Created by Sekanor.\n"
                + "Released on 16/06/2018.");
        
        addMessage("howToUse","\n"
                + "1. Import your list of goals in .txt format.\n"
                + "2. Generate your JSON board.\n"
                + "3. Copy it into clipboard, and paste it in BingoSync.\n"
                + "4. Enjoy !");
        
        addMessage("b_generateJson","Generate JSON");
        addMessage("b_generateJson_error","No file.");

        addMessage("b_copyClipboard","Copy to Clipboard");
        addMessage("b_copyClipboard_error","No JSON.");
        addMessage("b_copyClipboard_valid","Copied !");
    }
    
    /**
     * Adds a message to the messageList HashMap.
     * @param title Title&ID of the message.
     * @param message String linked to the title.
     */
    private void addMessage(String title, String message) {
        this.messageList.put(title, message);
    }
    
    /**
     * Returns a certain message after having entered its title.
     * @param title Title&ID of the message.
     * @return The string linked to the title.
     */
    public String get(String title) {
        return this.messageList.get(title);
    }
    
    /**
     * Returns the unique instance of the Message class.
     * @return The unique instance of the Message class.
     */
    public static Message getInstance() {
        if (instance == null) {
            instance = new Message();
        }
        return instance;
    }
    
}
