
CREATE TABLE DATE01(
	DAY	DATE
);

CREATE TABLE STRINGTEST(
	STRING VARCHAR2(100)
);

INSERT INTO STRINGTEST
VALUES ( 'test' );

INSERT INTO STRINGTEST
VALUES ( concat( 'test',TO_CHAR(SEQ01_SEQ.NEXTVAL, '999')) );

SELECT * FROM STRINGTEST ;
