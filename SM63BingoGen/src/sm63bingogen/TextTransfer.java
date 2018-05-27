/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm63bingogen;

/**
 * Implements clipboard-related methods.
 * http://www.javapractices.com/topic/TopicAction.do;jsessionid=8E8A62BBC50652649245BFD32735A71E?Id=82
 * @author javapractices.com
 */

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.io.*;

public final class TextTransfer implements ClipboardOwner {

  public static void test(String...  aArguments ){
    TextTransfer textTransfer = new TextTransfer();

    //display what is currently on the clipboard
    System.out.println("Clipboard contains:" + textTransfer.getClipboardContents());

    //change the contents and then re-display
    textTransfer.setClipboardContents("blah, blah, blah");
    System.out.println("Clipboard contains:" + textTransfer.getClipboardContents());
  }

   /**
   * Empty implementation of the ClipboardOwner interface.
   */
   @Override public void lostOwnership(Clipboard aClipboard, Transferable aContents){
     //do nothing
   }

  /**
  * Place a String on the clipboard, and make this class the
  * owner of the Clipboard's contents.
  */
  public void setClipboardContents(String aString){
    StringSelection stringSelection = new StringSelection(aString);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, this);
  }

  /**
  * Get the String residing on the clipboard.
  *
  * @return any text found on the Clipboard; if none found, return an
  * empty String.
  */
  public String getClipboardContents() {
    String result = "";
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    //odd: the Object param of getContents is not currently used
    Transferable contents = clipboard.getContents(null);
    boolean hasTransferableText =
      (contents != null) &&
      contents.isDataFlavorSupported(DataFlavor.stringFlavor)
    ;
    if (hasTransferableText) {
      try {
        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
      }
      catch (UnsupportedFlavorException | IOException ex){
        System.out.println(ex);
        ex.printStackTrace();
      }
    }
    return result;
  }
} 
