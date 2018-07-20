package secure;


import com.renory.secure.alhoritm.Password;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smit
 */
public class PasswordHashTest {
    
    @Test
    public void test1(){
        String pass = "password";
        String passHash = Password.getSaltedHash(pass);
        boolean result = Password.check(pass, passHash);
        
        assertEquals(true, result);
    }
}
