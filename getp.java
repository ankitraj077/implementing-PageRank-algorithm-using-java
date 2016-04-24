import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

 class Getpp{
	static int count=0;
	public ArrayList<String> getp(String filep)throws Exception
	{
	
 // public final static void main(String[] args) throws Exception {
 
	  
	  
    final ArrayList<String> list = new ArrayList<String>();

    ParserDelegator parserDelegator = new ParserDelegator();
    ParserCallback parserCallback = new ParserCallback() {
      public void handleText(final char[] data, final int pos) {
      }

      public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) {
        if (tag == Tag.A) {
			count++;
          String address = (String) attribute.getAttribute(Attribute.HREF);
          list.add(address);
        }
      }

      public void handleEndTag(Tag t, final int pos) {
      }

      public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) {
      }

      public void handleComment(final char[] data, final int pos) {
      }

      public void handleError(final java.lang.String errMsg, final int pos) {
      }
    };
    //parserDelegator.parse(new FileReader("jweb.html"), parserCallback, false);
	
	parserDelegator.parse(new FileReader(filep), parserCallback, false);
    //System.out.println(list);
	//System.out.println(count);
	//return count;
	return list;
  }
}