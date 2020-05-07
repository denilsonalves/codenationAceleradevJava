package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        textNullBlank(texto);

        int displace = -3;
        String text = texto.toLowerCase();
        StringBuilder textDecrypted = new StringBuilder();

        for(int i = 0; i < text.length(); i++){
            int character = text.charAt(i);
            char aux = 0;

            if(character >= 97 && character <= 122){
                if(character - displace  < 97){
                    aux = (char) (character - displace + 26);
                } else {
                    aux = (char) (character - displace);
                }
            } else if (character == 32 || character == 46 || character == 58){
                aux = (char) character;
            }else if(character > 47 && character < 58){
                aux = (char) character;
            }
            textDecrypted.append(aux);
        }
        return textDecrypted.toString();
    }

    @Override
    public String descriptografar(String texto) {
        textNullBlank(texto);

        int displace = -3;
        StringBuilder textDecrypted = new StringBuilder();
        String text = texto.toLowerCase();

        for(int i = 0; i < text.length(); i++){
            int character = text.charAt(i);
            char aux = 0;

            if(character >= 97 && character <= 122){
                if(character - displace  < 97){
                    aux = (char) (character + displace + 26);
                } else {
                    aux = (char) (character + displace);
                }
            } else if (character == 32 || character == 46 || character == 58){
                aux = (char) character;
            } else if(character > 47 && character < 58){
                aux = (char) character;
            }
            textDecrypted.append(aux);
        }
        return textDecrypted.toString();
    }

    private void textNullBlank(String texto) {
        if (texto == null) throw new NullPointerException();
        if (texto.isEmpty()) throw new IllegalArgumentException();
    }
}
