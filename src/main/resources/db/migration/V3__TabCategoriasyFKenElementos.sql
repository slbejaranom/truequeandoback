CREATE TABLE IF NOT EXISTS categorias (
	id serial PRIMARY KEY,
	descripcion varchar(200) not null
	);
	
ALTER TABLE elementos 
ADD CONSTRAINT  constraint_fk
FOREIGN KEY (categoria) 
REFERENCES categorias (id);