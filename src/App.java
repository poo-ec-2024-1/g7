public class App {
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja("Loja 1", "123456789", "123456789", "Rua 1");
        String[] servicos = {"Servico 1", "Servico 2", "Servico 3"};
        loja.setServicos(servicos);
        System.out.println("Loja: " + loja.getNome());
        System.out.println("CNPJ: " + loja.getCnpj());
        System.out.println("Telefone: " + loja.getTelefone());
        System.out.println("Endereco: " + loja.getEndereco());
        System.out.println("Servicos: ");
        for (String servico : loja.getServicos()) {
            System.out.println(servico);
        }
    }
}

