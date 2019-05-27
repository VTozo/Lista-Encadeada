class ListaEncadeada {

    private NodeLista primeiro = null;
    private NodeLista ultimo = null;

    NodeLista getPrimeiro() {
        return primeiro;
    }

    private boolean vazia() {
        return primeiro == null;
    }

    NodeLista inserePrimeiro(String dado) {
        NodeLista novo = new NodeLista(dado);
        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.proximo = primeiro;
            primeiro = novo;
        }

        return novo;
    }

    NodeLista insereDepois(String dado, NodeLista anterior) {
        if (anterior == ultimo)
            return insereUltimo(dado);

        NodeLista novo = new NodeLista(dado);
        novo.proximo = anterior.proximo;
        anterior.proximo = novo;
        return novo;
    }

    NodeLista insereUltimo(String dado) {
        NodeLista novo = new NodeLista(dado);
        if (vazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        return novo;
    }

    NodeLista insereOrdenado(String dado) {

        if (vazia() || primeiro.dado.compareTo(dado) >= 0) {
            return inserePrimeiro(dado);
        }

        if (ultimo.dado.compareTo(dado) <= 0) {
            return insereUltimo(dado);
        }

        NodeLista anterior = primeiro;
        NodeLista i = primeiro.proximo;
        while (i.dado.compareTo(dado) < 0) {
            anterior = i;
            i = i.proximo;
        }

        return insereDepois(dado, anterior);

    }

    void mostraLista() {
        if (vazia())
            return;

        NodeLista no = primeiro;
        System.out.print(no.dado);
        while (no.proximo != null) {
            no = no.proximo;
            System.out.print(", " + no.dado);
        }
        System.out.println();
    }

    String retiraPrimeiro() {
        String retorno = primeiro.dado;
        primeiro = primeiro.proximo;
        return retorno;
    }

    String retiraUltimo() {

        String retorno = ultimo.dado;

        NodeLista no = primeiro;
        while (no.proximo != ultimo) {
            no = no.proximo;
        }
        no.proximo = null;
        ultimo = no;

        return retorno;
    }

    String retiraDepois(NodeLista p) {

        if (p == ultimo)
            return "";

        String retorno = p.proximo.dado;

        p.proximo = p.proximo.proximo;

        return retorno;
    }

    String ultimoElemento() {
        return ultimo.dado;
    }

    NodeLista encontraElemento(String dado) {
        NodeLista no = primeiro;
        while (no.proximo != null) {
            if (no.dado.equals(dado))
                return no;
            no = no.proximo;
        }
        return null;
    }

    int tamanho() {
        if (vazia())
            return 0;

        NodeLista no = primeiro;
        int i = 1;
        while (no.proximo != null) {
            no = no.proximo;
            i++;
        }
        return i;
    }

    boolean existe(String dado) {
        NodeLista no = primeiro;
        while (no != null) {
            if (dado.equals(no.dado))
                return true;
            no = no.proximo;
        }
        return false;
    }

}
