-- Criação da tabela parcelamento com DATE
CREATE TABLE parcelamento (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    descricao VARCHAR(20) NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,
    quantidade_parcelas SMALLINT,
    data_criacao DATE NOT NULL
);

-- Adição da restrição de chave estrangeira
ALTER TABLE parcelamento
ADD CONSTRAINT fk_parcelamento_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente (id);
