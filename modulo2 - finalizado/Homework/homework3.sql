

-- Right outer join pessoa e contato
SELECT *

FROM PESSOA P
RIGHT JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA)


-- Right outer join pessoa, ENDERECO_PESSOA e PESSOA_X_PESSOA_ENDERECO
SELECT  *
		
FROM PESSOA P

RIGHT JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (PXPE.ID_PESSOA = P.ID_PESSOA)
RIGHT JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- right outer join todas as tabelas

SELECT *
	   
FROM PESSOA P
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (PXPE.ID_PESSOA = P.ID_PESSOA)
RIGHT JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)
RIGHT JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA);

-- outer full join 

SELECT *

FROM PESSOA P
FULL JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA)


-- outer full join pessoa, ENDERECO_PESSOA e PESSOA_X_PESSOA_ENDERECO
SELECT  *
		
FROM PESSOA P

FULL JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON (PXPE.ID_PESSOA = P.ID_PESSOA)
FULL JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)

-- outer full join todas as tabelas

SELECT *
	   
FROM PESSOA P
FULL JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (PXPE.ID_PESSOA = P.ID_PESSOA)
FULL JOIN ENDERECO_PESSOA EP ON (EP.ID_ENDERECO = PXPE.ID_ENDERECO)
FULL JOIN CONTATO C ON (C.ID_PESSOA = P.ID_PESSOA);

-- Exists

SELECT * FROM PESSOA p 
WHERE EXISTS (
	SELECT *
	FROM PESSOA_X_PESSOA_ENDERECO pxpe 
	WHERE PXPE.ID_PESSOA = P.ID_PESSOA 
)

SELECT NOME, ID_PESSOA FROM PESSOA 
UNION 
SELECT LOGRADOURO, ID_ENDERECO FROM ENDERECO_PESSOA 