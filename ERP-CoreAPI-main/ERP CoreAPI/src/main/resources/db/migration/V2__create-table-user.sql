CREATE TABLE coreapi.user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(150) NOT NULL,
    
    PRIMARY KEY (id)
);
