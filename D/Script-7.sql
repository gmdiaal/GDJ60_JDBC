
DROP TABLE MEMBER;
DROP TABLE BOARD;

CREATE TABLE MEMBER_ (
	MEMBER_ID VARCHAR2(100),
	MEMBER_PW VARCHAR2(200),
	MEMBER_NAME VARCHAR2(100),
	MEMBER_PHONE VARCHAR2(100),
	MEMBER_EMAIL VARCHAR2(200)
	
)

CREATE TABLE ADDRESS (
	ADDRESS_NUM	NUMBER,
	MEMBER_ID VARCHAR2(100),
	ADDRESS_ADDRESS VARCHAR2(500),
	ADDRESS_PHONE VARCHAR2(100),
	ADDRESS_NAME VARCHAR2(100)
)

ALTER TABLE MEMBER ADD CONSTRAINT PK PRIMARY KEY (MEMBER_ID);
ALTER TABLE ADDRESS ADD CONSTRAINT ADDRESS_NUM_PK PRIMARY KEY (ADDRESS_NUM);
ALTER TABLE ADDRESS ADD CONSTRAINT ADDRESS_MEMBER_ID_FK FOREIGN KEY (MEMBER_ID) 
REFERENCES MEMBER (MEMBER_ID);

INSERT INTO MEMBER
VALUES ('TEST','TEST','TEST','TEST','TEST');
INSERT INTO ADDRESS
VALUES (1,'TEST','TEST','TEST','TEST');
	

CREATE SEQUENCE SEQ01_SEQ;

INSERT INTO ADDRESS
VALUES (SEQ01_SEQ.NEXTVAL,'TEST','TEST','TEST','TEST');

SELECT * FROM USER_SEQUENCES;

SELECT * FROM ADDRESS a ;
