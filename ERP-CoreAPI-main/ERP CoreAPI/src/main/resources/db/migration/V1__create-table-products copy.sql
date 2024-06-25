CREATE TABLE coreapi.product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    marca VARCHAR(25) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    preco FLOAT(10) NOT NULL,
    quantidade FLOAT(10) NOT NULL,
    gtin BIGINT (14) NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    stats BOOLEAN NOT NULL DEFAULT TRUE, 
    
    PRIMARY KEY (id)
);
