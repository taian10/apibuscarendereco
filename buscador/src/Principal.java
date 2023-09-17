public class Principal {
    public static void main(String[] args) {


        ConsultaCep consultaCep = new ConsultaCep();
        Endereco novoEndereco = consultaCep.buscaEndereco("04937000");
        System.out.println(novoEndereco);



    }
}