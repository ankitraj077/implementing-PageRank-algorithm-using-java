import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

public class Main {
	static int count=0;
	public int total(String filep)throws Exception
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

     //
    };
    
	
	parserDelegator.parse(new FileReader(filep), parserCallback, false);
    //System.out.println(list);
	//System.out.println(count);
	return count;
  }
}