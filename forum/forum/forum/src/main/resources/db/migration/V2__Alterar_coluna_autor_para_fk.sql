ALTER TABLE topicos DROP COLUMN autor;


ALTER TABLE topicos
ADD CONSTRAINT fk_topico_autor
FOREIGN KEY (autor_id)
REFERENCES usuarios(id);
