package excel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class XlsMergeUtil {
	private static Logger logger = 
	
	static void write(OutputStream out, byte[] data) {  
	    POIFSFileSystem fs = new POIFSFileSystem();  
	    // Write out the Workbook stream  
	    try {  
	      fs.createDocument(new ByteArrayInputStream(data), "Workbook");  
	      fs.writeFilesystem(out);  
	      out.flush();  
	    } catch (IOException e) {  
	      e.printStackTrace();  
	    } finally {  
	      try {  
	        out.close();  
	      } catch (IOException e) {  
	        e.printStackTrace();  
	      }  
	    }  
	  } 
	
	static List<Sheet> getSheets(Workbook workbook, List records) {  
	    int recOffset = workbook.getNumRecords();  
	    int sheetNum = 0;  
	  
	    // convert all LabelRecord records to LabelSSTRecord  
	    convertLabelRecords(records, recOffset, workbook);  
	    List<Sheet> sheets = new ArrayList();  
	    while (recOffset < records.size()) {  
	      Sheet sh = Sheet.createSheet(records, sheetNum++, recOffset);  
	  
	      recOffset = sh.getEofLoc() + 1;  
	      if (recOffset == 1) {  
	        break;  
	      }  
	      sheets.add(sh);  
	    }  
	    return sheets;  
	  }  
}
