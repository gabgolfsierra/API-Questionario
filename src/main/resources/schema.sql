CREATE TABLE Usuario(
    id int AUTO_INCREMENT NOT NULL,
    login varchar(50),
    senha varchar(30),
    PRIMARY KEY (id)
);

CREATE TABLE Questionario(
    id int AUTO_INCREMENT NOT NULL,
    data_criacao date,
    nome varchar(50),
    descricao varchar(100),
    id_usuario_criacao int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario_criacao) REFERENCES Usuario(id)
);

CREATE TABLE Resp(
    id_questionario int,
    id_usuario int,
    data date,
    FOREIGN KEY (id_questionario) REFERENCES Questionario(id),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);

CREATE TABLE Perguntas(
    id int AUTO_INCREMENT NOT NULL,
    descricao varchar(100),
    id_questionario int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_questionario) REFERENCES Questionario(id)
);