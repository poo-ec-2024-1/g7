package com.lavamarket;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "usuario")
public abstract class Usuario {

    @DatabaseField(generatedId = true)
    protected int id;

    @DatabaseField
    protected String nome;

    @DatabaseField
    protected String cpf;

    @DatabaseField
    protected String telefone;

    @DatabaseField
    protected String endereco;

    @DatabaseField
    protected String usuario;

    @DatabaseField
    protected String senha;
}


