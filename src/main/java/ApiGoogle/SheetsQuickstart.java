package ApiGoogle;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SheetsQuickstart {
   
    
    public static void main(String... args) throws IOException, GeneralSecurityException {


        //INIT
        SpreadsheetSnippets spreadsheetSnippets=  new SpreadsheetSnippets();
        spreadsheetSnippets.init();

        
        //ID OF spreedSheet
        //final String spreadsheetId = "1_wYqKTN57uwoshND3snSbuzzhOHqFQnYkMoDCAaotLw";
        final String spreadsheetId = "1R_dZQNYTqObHshByD447M3Qk2lG5Rr4lOhORre4qsic";
        
        //READ Sample
        String range = "Sheet1!A2:E";        
        List<List<Object>> values = spreadsheetSnippets.getValues(spreadsheetId, range);

        //============ Display value =================
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
            	String Cel0 = (String) row.get(0);
            	String Cel4 = "";
            	if (row.size()>=3)  Cel4= (String) row.get(0);
                System.out.printf("%s, %s\n",Cel0, Cel4);
            }
        }
        //==========================================
        
        
        //UPdate Sample
        range = "Sheet1!A10:D";
        values = Arrays.asList(
    	        Arrays.asList(
    	        		new Object[]{"abc","","xyz","pqr","Americain"}
    	        )
    	        // Additional rows ...
    	        , Arrays.asList(
    	        		new Object[]{"abc","klm","xyz","pqr","Canadien"}
    	        )
    	);
        
        
        
        SheetSAVM _SheetSAVM = new SheetSAVM();
        _SheetSAVM.initOdreChamps("NOM,PRENOM,ADR_NUM,ADR_RUE,ADR_CODE_POSTAL,ADR_VILLE,TEL,EMAIL,OEUVRE_TYPE,OEUVRE_TITRE,OEUVRE_DETAIL,OEUVRE_DIM,OEUVRE_PRIX,SIRET_MDA,DISPO_GARDE,SITE_INTERNET,PHOTO");								  
		//Liste de depart
		_SheetSAVM.listeDepart = new ArrayList<Object>( Arrays.asList("NOM","FASSEL","ADR_RUE","DUMESNIL","OEUVRE_TITRE","Peinture"));        
		//ArrayList<String> aListDays = new ArrayList<String>( Arrays.asList("Sun", "Mon", "Tue") );		
		//ArrayList<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));		
		_SheetSAVM.creteListeShhet();
		System.out.println("----");
        List<List<Object>> value2 = new ArrayList<List<Object>>(); 			
        value2.add(_SheetSAVM.ListeArrive); 
        
        
    	String  valueInputOption = "USER_ENTERED";
        spreadsheetSnippets.appendValues(spreadsheetId, range, valueInputOption, value2);
        
    }
}