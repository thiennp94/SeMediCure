package coms309.backend.securityFun;

public class Cipher {

    public String toCipher(String input)
    {
        String output = "";
        for(int i=0; i<input.length(); i++)
        {
            output = output + (input.charAt(i) + 5);
        }
        return output;
    }

}
