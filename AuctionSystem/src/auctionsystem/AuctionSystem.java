package auctionsystem;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import controller.*;

public class AuctionSystem {

    public static void main(String[] args) {
        createTheme ();
        NewClientController newClient = new NewClientController ( );
    }
    static void createTheme (){
        try {      
            FlatOneDarkIJTheme.setup();
        }catch(Exception e){
            
        }
    }
    
}
